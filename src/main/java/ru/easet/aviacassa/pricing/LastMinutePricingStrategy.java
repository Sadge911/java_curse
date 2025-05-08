package ru.easet.aviacassa.pricing;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Стратегия "горящего" рейса (<=3 дней).
 */
public class LastMinutePricingStrategy implements TicketPricingStrategy {
    @Override
    public double calculatePrice(double basePrice, LocalDate purchaseDate, LocalDate flightDate) {
        long daysUntil = ChronoUnit.DAYS.between(purchaseDate, flightDate);
        if (daysUntil <= 3) {
            return basePrice * 0.8; // 20% скидка
        }
        return basePrice;
    }


}