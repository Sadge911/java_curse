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
import ru.easet.aviacassa.verification.AdultPassengerVerification;
import ru.easet.aviacassa.verification.PassengerVerification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Система бронирования билетов.
 */
public class TicketBookingSystem {
    private List<Flight> flights = new ArrayList<>();
    private TicketPricingStrategy advanceStrategy = new AdvancePurchasePricingStrategy();
    private TicketPricingStrategy lastMinuteStrategy = new LastMinutePricingStrategy();
    private PassengerVerification verification = new AdultPassengerVerification();
    private FlightSearch search = new FlightSearchImpl(flights);

    /**
     * Добавляет новый рейс в систему.
     */
    public void addFlight(ScheduledFlight flight) {
        flights.add(flight);
    }

    /**
     * Продает билет, если пассажир совершеннолетний и есть место.
     */
    public FlightTicket sellTicket(Passenger passenger, ScheduledFlight flight,
                                   String ticketClass, LocalDate purchaseDate) {
        if (!verification.verify(passenger.getBirthDate())) {
            System.out.println("Ошибка: пассажир несовершеннолетний.");
            return null;
        }
        if (!flight.reserveSeat(ticketClass)) {
            System.out.println("Ошибка: нет доступных мест в классе " + ticketClass);
            return null;
        }
        double basePrice = flight.getBasePrice(ticketClass);
        double price1 = advanceStrategy.calculatePrice(basePrice, purchaseDate, flight.getDepartureDateTime().toLocalDate());
        double price2 = lastMinuteStrategy.calculatePrice(basePrice, purchaseDate, flight.getDepartureDateTime().toLocalDate());
        double finalPrice = Math.min(price1, price2);
        FlightTicket ticket = new FlightTicket(passenger, flight, ticketClass, finalPrice, purchaseDate);
        System.out.println("Билет успешно куплен. Итоговая цена: " + finalPrice);
        return ticket;
    }

    /**
     * Ищет подходящий рейс.
     */
    public List<Flight> findSuitableFlights(String departureCity, String arrivalCity,
                                            LocalDate travelDate, String ticketClass) {
        return search.findFlights(departureCity, arrivalCity, travelDate, ticketClass);
    }

    /**
     * Выводит информацию о рейсе.
     */
    public void displayFlightInfo(Flight flight) {
        System.out.println("Рейс " + flight.getFlightNumber() + ": "
                + flight.getDepartureCity() + " -> " + flight.getArrivalCity()
                + ", Вылет: " + flight.getDepartureDateTime()
                + ", Свободно мест (Economy): " + flight.getAvailableSeats("Economy")
                + ", (Business): " + flight.getAvailableSeats("Business"));
    }

    /**
     * Возвращает незменяемый список всех рейсов в системе.
     */
    public List<Flight> getAllFlights() {
        return Collections.unmodifiableList(flights);
    }

    /**
     * Ищет рейс по его номеру (без учёта регистра).
     */
    public Optional<Flight> findFlightByNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst();
    }
}