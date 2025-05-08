package ru.easet.aviacassa.search;


import ru.easet.aviacassa.model.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Поиск рейсов по заданным критериям из внутреннего списка.
 */
public class FlightSearchImpl implements FlightSearch {
    private List<Flight> flights;

    public FlightSearchImpl(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> findFlights(String departureCity, String arrivalCity,
                                    LocalDate travelDate, String ticketClass) {
        List<Flight> result = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDepartureCity().equalsIgnoreCase(departureCity)
                    && f.getArrivalCity().equalsIgnoreCase(arrivalCity)
                    && f.getDepartureDateTime().toLocalDate().equals(travelDate)
                    && f.getAvailableSeats(ticketClass) > 0) {
                result.add(f);
            }
        }
        return result;
    }

}