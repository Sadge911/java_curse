package ru.easet.aviacassa.verification;

import java.time.LocalDate;

/**
 * Интерфейс для проверки пассажира.
 */
public interface PassengerVerification {
    /**
     * Проверяет, может ли пассажир купить билет.
     *
     * @param birthDate дата рождения пассажира
     * @return true, если пассажир совершеннолетний
     */
    boolean verify(LocalDate birthDate);
}