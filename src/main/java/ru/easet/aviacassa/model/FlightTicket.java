package ru.easet.aviacassa.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * Конкретная реализация билета.
 */
public class FlightTicket extends Ticket {

    /**
     * Jackson‐конструктор для десериализации из JSON.
     *
     * @param passenger    пассажир
     * @param flight       рейс
     * @param ticketClass  класс билета
     * @param price        стоимость
     * @param purchaseDate дата покупки
     */
    @JsonCreator
    public FlightTicket(
            @JsonProperty("passenger") Passenger passenger,
            @JsonProperty("flight") Flight flight,
            @JsonProperty("ticketClass") String ticketClass,
            @JsonProperty("price") double price,
            @JsonProperty("purchaseDate") LocalDate purchaseDate
    ) {
        super(passenger, flight, ticketClass, price, purchaseDate);
    }
}