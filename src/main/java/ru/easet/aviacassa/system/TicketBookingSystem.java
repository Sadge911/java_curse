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
import java.util.stream.Collectors;

/**
 * Система бронирования, поиска и хранения рейсов и билетов.
 */
public class TicketBookingSystem {
    private final FlightRepository flightRepo;
    private final TicketRepository ticketRepo;

    private final List<Flight> flights;
    private final List<FlightTicket> tickets;

    private final TicketPricingStrategy advanceStrategy;
    private final TicketPricingStrategy lastMinuteStrategy;
    private final PassengerVerification verification;
    private final FlightSearch search;

    /**
     * При инициализации загружает все данные из JSON-файлов.
     */
    public TicketBookingSystem() {
        this.flightRepo = new FlightRepository();
        this.ticketRepo = new TicketRepository();
        this.flights = flightRepo.load();
        this.tickets = ticketRepo.load();

        // вычитает из каждого рейса уже проданные билеты:
        for (FlightTicket ticket : tickets) {
            findFlightByNumber(ticket.getFlight().getFlightNumber())
                    .ifPresent(flight -> flight.reserveSeat(ticket.getTicketClass()));
        }

        this.advanceStrategy = new AdvancePurchasePricingStrategy();
        this.lastMinuteStrategy = new LastMinutePricingStrategy();
        this.verification = new AdultPassengerVerification();
        this.search = new FlightSearchImpl(flights);
    }

    /**
     * Добавляет новый рейс и сразу сохраняет весь список в файл.
     */
    public void addFlight(ScheduledFlight newFlight) {
        flights.add(newFlight);
        flightRepo.save(flights);
    }

    /**
     * Продаёт билет для взрослого пассажира, резервирует место,
     * вычисляет лучшую цену и сохраняет билет.
     *
     * @return проданный FlightTicket или null при ошибке
     */
    public FlightTicket sellTicket(Passenger passenger,
                                   ScheduledFlight flight,
                                   String ticketClass,
                                   LocalDate purchaseDate) {
        // 1) проверяем возраст
        if (!verification.verify(passenger.getBirthDate())) {
            throw new IllegalArgumentException("Пассажир несовершеннолетний.");
        }
        // 2) проверяем, есть ли место
        if (!flight.reserveSeat(ticketClass)) {
            throw new IllegalArgumentException("Нет доступных мест в классе " + ticketClass);
        }
        // 3) рассчитываем цену
        double basePrice = flight.getBasePrice(ticketClass);
        double priceAdv = advanceStrategy.calculatePrice(basePrice, purchaseDate, flight.getDepartureDateTime().toLocalDate());
        double priceLastMin = lastMinuteStrategy.calculatePrice(basePrice, purchaseDate, flight.getDepartureDateTime().toLocalDate());
        double finalPrice = Math.min(priceAdv, priceLastMin);

        FlightTicket ticket = new FlightTicket(passenger, flight, ticketClass, finalPrice, purchaseDate);
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
     * Сохраняет текущий список рейсов в файл.
     */
    public void saveAllFlights() {
        flightRepo.save(flights);
    }


    /**
     * Возвращает незменяемый список всех проданных билетов.
     */
    public List<FlightTicket> getAllTickets() {
        return Collections.unmodifiableList(tickets);
    }

    /**
     * Возвращает список проданных билетов для указанного рейса.
     */
    public List<FlightTicket> getTicketsForFlight(String flightNumber) {
        return tickets.stream()
                .filter(t -> t.getFlight().getFlightNumber().equalsIgnoreCase(flightNumber))
                .collect(Collectors.toList());
    }
}
