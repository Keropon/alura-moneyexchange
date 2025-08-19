package com.alura.moneyexchange;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtendedConversionResult {
    private final ExtendedCurrency fromCurrency;
    private final ExtendedCurrency toCurrency;
    private final double originalAmount;
    private final double convertedAmount;
    private final double exchangeRate;
    private final LocalDateTime timestamp;

    public ExtendedConversionResult(ExtendedCurrency fromCurrency, ExtendedCurrency toCurrency, double originalAmount, double convertedAmount, double exchangeRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.exchangeRate = exchangeRate;
        this.timestamp = LocalDateTime.now();
    }

    public ExtendedCurrency getFromCurrency() {
        return fromCurrency;
    }

    public ExtendedCurrency getToCurrency() {
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
        return String.format("%.2f %s = %.2f %s (Tasa: %.6f) [%s]",
                originalAmount, fromCurrency.getCode(),
                convertedAmount, toCurrency.getCode(),
                exchangeRate, timestamp.format(formatter));
    }

    public String getFormattedResult() {
        return String.format("El valor de %.2f [%s - %s] corresponde al valor final de =>>> %.2f [%s - %s]",
                originalAmount, fromCurrency.getCode(), fromCurrency.getName(),
                convertedAmount, toCurrency.getCode(), toCurrency.getName());
    }
}