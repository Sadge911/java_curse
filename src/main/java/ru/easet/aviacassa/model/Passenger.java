package ru.easet.aviacassa.model;

import java.time.LocalDate;

/**
 * Пассажир с данными для проверки.
 */
public class Passenger {
    private String name;
    private LocalDate birthDate;
    private String passportNumber;

    public Passenger(String name, LocalDate birthDate, String passportNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
    }

    public String getName() { return name; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getPassportNumber() { return passportNumber; }
}