package ru.easet.aviacassa.verification;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Проверка совершеннолетия пассажира.
 */
public class AdultPassengerVerification implements PassengerVerification {
    @Override
    public boolean verify(LocalDate birthDate) {
        long age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        return age >= 18;
    }

}