package ru.easet.aviacassa.model;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Класс конкретного рейса, расширяющий Flight.
 */
public class ScheduledFlight extends Flight {
    private Crew crew;
    private double basePriceEconomy;
    private double basePriceBusiness;

    /**
     * @param flightNumber       номер рейса
     * @param departureCity      город отправления
     * @param arrivalCity        город прибытия
     * @param departureDateTime  дата и время вылета
     * @param seatsByClass       места по классам
     * @param crew               экипаж рейса
     * @param basePriceEconomy   базовая цена эконом-класса
     * @param basePriceBusiness  базовая цена бизнес-класса
     */
    public ScheduledFlight(String flightNumber, String departureCity, String arrivalCity,
                           LocalDateTime departureDateTime, Map<String, Integer> seatsByClass,
                           Crew crew, double basePriceEconomy, double basePriceBusiness) {
        super(flightNumber, departureCity, arrivalCity, departureDateTime, seatsByClass);
        this.crew = crew;
        this.basePriceEconomy = basePriceEconomy;
        this.basePriceBusiness = basePriceBusiness;
    }

    public Crew getCrew() { return crew; }

    /**
     * Возвращает базовую цену по классу.
     */
    public double getBasePrice(String ticketClass) {
        switch (ticketClass) {
            case "Business": return basePriceBusiness;
            case "Economy":
            default: return basePriceEconomy;
        }
    }
}