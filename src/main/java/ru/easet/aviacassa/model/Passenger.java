package ru.easet.aviacassa.model;

import java.time.LocalDate;

/**
 * Пассажир с данными для проверки.
 */
public class Passenger {
    private String name;
    private LocalDate birthDate;
    private String passportNumber;

    /** Jackson: default‐конструктор */
    public Passenger() {}

    public Passenger(String name, LocalDate birthDate, String passportNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
    }

    public String getName() { return name; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getPassportNumber() { return passportNumber; }


    // ========== Сеттеры (для Jackson) ==========
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}