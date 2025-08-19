package com.alura.moneyexchange;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    private final ExchangeRateApiClient apiClient;
    private final List<ConversionResult> conversionHistory;

    public CurrencyConverter() {
        this.apiClient = new ExchangeRateApiClient();
        this.conversionHistory = new ArrayList<>();
    }

    public ConversionResult convertCurrency(Currency fromCurrency, Currency toCurrency, double amount) 
            throws IOException, InterruptedException {
        
        ExchangeRateResponse response = apiClient.getExchangeRates(fromCurrency.getCode());
        
        if (!"success".equals(response.getResult())) {
            throw new RuntimeException("Error al obtener las tasas de cambio");
        }

        Map<String, Double> rates = response.getConversionRates();
        Double exchangeRate = rates.get(toCurrency.getCode());
        
        if (exchangeRate == null) {
            throw new RuntimeException("No se encontro la tasa de cambio para " + toCurrency.getCode());
        }

        double convertedAmount = amount * exchangeRate;
        
        ConversionResult result = new ConversionResult(fromCurrency, toCurrency, amount, convertedAmount, exchangeRate);
        conversionHistory.add(result);
        
        return result;
    }

    public List<ConversionResult> getConversionHistory() {
        return new ArrayList<>(conversionHistory);
    }

    public void clearHistory() {
        conversionHistory.clear();
    }
}