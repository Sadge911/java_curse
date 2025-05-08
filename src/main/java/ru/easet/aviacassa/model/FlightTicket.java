package ru.easet.aviacassa.model;

import java.time.LocalDate;

/**
 * Конкретная реализация билета.
 */
public class FlightTicket extends Ticket {
    /**
     * @param passenger     пассажир
     * @param flight        рейс
     * @param ticketClass   класс билета
     * @param price         стоимость
     * @param purchaseDate  дата покупки
     */
    public FlightTicket(Passenger passenger, Flight flight, String ticketClass,
                        double price, LocalDate purchaseDate) {
        super(passenger, flight, ticketClass, price, purchaseDate);
    }
}