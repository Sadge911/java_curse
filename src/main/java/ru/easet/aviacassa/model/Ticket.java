package ru.easet.aviacassa.model;

import java.time.LocalDate;

/**
 * Абстрактный класс билета.
 */
abstract class Ticket {
    protected String ticketClass;
    protected double price;
    protected LocalDate purchaseDate;
    protected Passenger passenger;
    protected Flight flight;

    /**
     * @param passenger     пассажир
     * @param flight        рейс
     * @param ticketClass   класс билета
     * @param price         стоимость
     * @param purchaseDate  дата покупки
     */
    public Ticket(Passenger passenger, Flight flight, String ticketClass,
                  double price, LocalDate purchaseDate) {
        this.passenger = passenger;
        this.flight = flight;
        this.ticketClass = ticketClass;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public String getTicketClass() { return ticketClass; }
    public double getPrice() { return price; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public Passenger getPassenger() { return passenger; }
    public Flight getFlight() { return flight; }
}