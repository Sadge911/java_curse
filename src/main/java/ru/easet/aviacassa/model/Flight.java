package ru.easet.aviacassa.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * Абстрактный класс для рейса.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "flightType",
        defaultImpl = ScheduledFlight.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ScheduledFlight.class, name = "scheduled")
})
public abstract class Flight {
    protected String flightNumber;
    protected String departureCity;
    protected String arrivalCity;
    protected LocalDateTime departureDateTime;
    protected int totalSeats;
    protected Map<String, Integer> seatsByClass;


    // Jackson-совместимый конструктор без параметров
    public Flight() {
        this.seatsByClass = new HashMap<>();
    }

    /**
     * @param flightNumber       номер рейса
     * @param departureCity      город отправления
     * @param arrivalCity        город прибытия
     * @param departureDateTime  дата и время вылета
     * @param seatsByClass       количество мест по классам
     */
    public Flight(String flightNumber, String departureCity, String arrivalCity,
                  LocalDateTime departureDateTime, Map<String, Integer> seatsByClass) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDateTime = departureDateTime;
        this.seatsByClass = new HashMap<>(seatsByClass);
        this.totalSeats = seatsByClass.values().stream().mapToInt(Integer::intValue).sum();
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDepartureCity() { return departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public LocalDateTime getDepartureDateTime() { return departureDateTime; }
    public int getAvailableSeats(String ticketClass) { return seatsByClass.getOrDefault(ticketClass, 0); }

    /**
     * Резервирует место в указанном классе.
     *
     * @param ticketClass класс билета
     * @return true, если место было успешно забронировано
     */
    public boolean reserveSeat(String ticketClass) {
        int available = getAvailableSeats(ticketClass);
        if (available > 0) {
            seatsByClass.put(ticketClass, available - 1);
            return true;
        }
        return false;
    }


    // Для Jackson
    public void setSeatsByClass(Map<String, Integer> seatsByClass) {
        this.seatsByClass = new HashMap<>(seatsByClass);
        this.totalSeats = seatsByClass.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}