package ru.easet.aviacassa.system;

import ru.easet.aviacassa.model.Flight;
import ru.easet.aviacassa.model.FlightTicket;
import ru.easet.aviacassa.model.Passenger;
import ru.easet.aviacassa.model.ScheduledFlight;
import ru.easet.aviacassa.pricing.AdvancePurchasePricingStrategy;
import ru.easet.aviacassa.pricing.LastMinutePricingStrategy;
import ru.easet.aviacassa.pricing.TicketPricingStrategy;
import ru.easet.aviacassa.search.FlightSearch;
import ru.easet.aviacassa.search.FlightSearchImpl;
import ru.easet.aviacassa.storage.FlightRepository;
import ru.easet.aviacassa.storage.TicketRepository;
import ru.easet.aviacassa.verification.AdultPassengerVerification;
import ru.easet.aviacassa.verification.PassengerVerification;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Система бронирования и хранения рейсов и билетов.
 */
public class TicketBookingSystem {
    private final FlightRepository flightRepo;
    private final TicketRepository ticketRepo;

    private final List<Flight> flights;
    private final List<FlightTicket> tickets;

    private final TicketPricingStrategy advanceStrategy = new AdvancePurchasePricingStrategy();
    private final TicketPricingStrategy lastMinuteStrategy = new LastMinutePricingStrategy();
    private final PassengerVerification verification = new AdultPassengerVerification();
    private final FlightSearch search;

    /**
     * При создании загружает все рейсы и билеты из JSON-файлов.
     */
    public TicketBookingSystem() {
        this.flightRepo = new FlightRepository();
        this.ticketRepo = new TicketRepository();

        this.flights = flightRepo.load();
        this.tickets = ticketRepo.load();
        this.search = new FlightSearchImpl(flights);
    }

    /**
     * Добавляет новый рейс и сохраняет весь список в файл.
     *
     * @param flight новый рейс
     */
    public void addFlight(ScheduledFlight flight) {
        flights.add(flight);
        flightRepo.save(flights);
    }

    /**
     * Продаёт билет, если пассажир совершеннолетний и в классе есть свободные места,
     * сохраняет проданный билет в файл.
     *
     * @param passenger    пассажир
     * @param flight       рейс
     * @param ticketClass  класс билета ("Economy" или "Business")
     * @param purchaseDate дата покупки
     * @return объект проданного билета или null при ошибке
     */
    public FlightTicket sellTicket(Passenger passenger,
                                   ScheduledFlight flight,
                                   String ticketClass,
                                   LocalDate purchaseDate) {
        if (!verification.verify(passenger.getBirthDate())) {
            System.out.println("Ошибка: пассажир несовершеннолетний.");
            return null;
        }
        if (!flight.reserveSeat(ticketClass)) {
            System.out.println("Ошибка: нет доступных мест в классе " + ticketClass);
            return null;
        }
        double basePrice = flight.getBasePrice(ticketClass);
        double priceAdvance = advanceStrategy.calculatePrice(
                basePrice,
                purchaseDate,
                flight.getDepartureDateTime().toLocalDate()
        );
        double priceLastMinute = lastMinuteStrategy.calculatePrice(
                basePrice,
                purchaseDate,
                flight.getDepartureDateTime().toLocalDate()
        );
        double finalPrice = Math.min(priceAdvance, priceLastMinute);

        FlightTicket ticket = new FlightTicket(
                passenger, flight, ticketClass, finalPrice, purchaseDate
        );
        tickets.add(ticket);
        ticketRepo.save(tickets);

        System.out.println("Билет успешно куплен. Итоговая цена: " + finalPrice);
        return ticket;
    }

    /**
     * Ищет список подходящих рейсов по заданным критериям.
     *
     * @param departureCity город отправления
     * @param arrivalCity   город прибытия
     * @param travelDate    дата вылета
     * @param ticketClass   класс билета
     * @return список рейсов
     */
    public List<Flight> findSuitableFlights(String departureCity,
                                            String arrivalCity,
                                            LocalDate travelDate,
                                            String ticketClass) {
        return search.findFlights(departureCity, arrivalCity, travelDate, ticketClass);
    }

    /**
     * Выводит информацию о рейсе в консоль.
     *
     * @param flight рейс
     */
    public void displayFlightInfo(Flight flight) {
        System.out.println("Рейс " + flight.getFlightNumber() + ": "
                + flight.getDepartureCity() + " -> " + flight.getArrivalCity()
                + ", Вылет: " + flight.getDepartureDateTime()
                + ", Свободно мест (Economy): " + flight.getAvailableSeats("Economy")
                + ", (Business): " + flight.getAvailableSeats("Business"));
    }

    /**
     * Возвращает незменяемый список всех рейсов.
     */
    public List<Flight> getAllFlights() {
        return Collections.unmodifiableList(flights);
    }

    /**
     * Ищет рейс по его номеру без учёта регистра.
     *
     * @param flightNumber номер рейса
     * @return Optional с рейсом или пустой, если не найден
     */
    public Optional<Flight> findFlightByNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst();
    }

    /**
     * Возвращает незменяемый список всех проданных билетов.
     */
    public List<FlightTicket> getAllTickets() {
        return Collections.unmodifiableList(tickets);
    }
}
