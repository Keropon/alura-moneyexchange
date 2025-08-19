package com.alura.moneyexchange;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionResult {
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final double originalAmount;
    private final double convertedAmount;
    private final double exchangeRate;
    private final LocalDateTime timestamp;

    public ConversionResult(Currency fromCurrency, Currency toCurrency, double originalAmount, double convertedAmount, double exchangeRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.exchangeRate = exchangeRate;
        this.timestamp = LocalDateTime.now();
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("%.2f %s = %.2f %s (Tasa: %.4f) [%s]",
                originalAmount, fromCurrency.getCode(),
                convertedAmount, toCurrency.getCode(),
                exchangeRate, timestamp.format(formatter));
    }

    public String getFormattedResult() {
        return String.format("El valor de %.2f [%s] corresponde al valor final de =>>> %.2f [%s]",
                originalAmount, fromCurrency.getName(),
                convertedAmount, toCurrency.getName());
    }
}