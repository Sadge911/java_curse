package ru.easet.aviacassa.search;

import ru.easet.aviacassa.model.Flight;

import java.time.LocalDate;
import java.util.List;

/**
 * Интерфейс для поиска рейсов по критериям.
 */
public interface FlightSearch {
    /**
     * найти рейсы по городу отправления, прибытия, дате и классу билета.
     *
     * @param departureCity город отправления
     * @param arrivalCity   город прибытия
     * @param travelDate    дата полета
     * @param ticketClass   класс билета (Economy, Business и т.д.)
     * @return список подходящих рейсов
     */
    List<Flight> findFlights(String departureCity, String arrivalCity, LocalDate travelDate, String ticketClass);
}