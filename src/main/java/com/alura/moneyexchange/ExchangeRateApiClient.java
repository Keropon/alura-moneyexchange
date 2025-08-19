package com.alura.moneyexchange;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Properties;

public class ExchangeRateApiClient {
    private final HttpClient httpClient;
    private final Gson gson;
    private final String apiKey;
    private final String baseUrl;

    public ExchangeRateApiClient() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.gson = new Gson();
        
        Properties config = loadConfig();
        this.apiKey = config.getProperty("api.key");
        this.baseUrl = config.getProperty("api.base.url");
    }

    private Properties loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("No se pudo encontrar el archivo config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la configuracion: " + e.getMessage());
        }
        return properties;
    }

    public ExchangeRateResponse getExchangeRates(String baseCurrency) throws IOException, InterruptedException {
        String url = baseUrl + apiKey + "/latest/" + baseCurrency;
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la API: " + response.statusCode() + " - " + response.body());
        }

        return gson.fromJson(response.body(), ExchangeRateResponse.class);
    }
}