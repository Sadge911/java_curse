package ru.easet.aviacassa.pricing;

import java.time.LocalDate;

/**
 * Интерфейс для стратегии ценообразования билетов.
 */
public interface TicketPricingStrategy {
    /**
     * Вычислить цену билета на основе базовой цены и времени покупки.
     *
     * @param basePrice       базовая цена билета
     * @param purchaseDate    дата покупки
     * @param flightDate      дата вылета
     * @return скорректированная цена
     */
    double calculatePrice(double basePrice, LocalDate purchaseDate, LocalDate flightDate);
}