package ru.easet.aviacassa.pricing;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Стратегия скидки за раннюю покупку (>30 дней).
 */
public class AdvancePurchasePricingStrategy implements TicketPricingStrategy {
    @Override
    public double calculatePrice(double basePrice, LocalDate purchaseDate, LocalDate flightDate) {
        long daysUntil = ChronoUnit.DAYS.between(purchaseDate, flightDate);
        if (daysUntil > 30) {
            return basePrice * 0.9; // 10% скидка
        }
        return basePrice;
    }

}