package ru.easet.aviacassa.verification;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Проверка совершеннолетия пассажира.
 */
public class AdultPassengerVerification implements PassengerVerification {

    /**
     * Возвращает true, если пассажиру уже исполнилось 18 лет на текущую дату.
     */
    @Override
    public boolean verify(LocalDate birthDate) {
        if (birthDate == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthDate, today);
        return age.getYears() >= 18;
    }

}