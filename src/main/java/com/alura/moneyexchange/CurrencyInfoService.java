package com.alura.moneyexchange;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyInfoService {
    
    public void mostrarMonedasSoportadas() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("           MONEDAS SOPORTADAS POR EXCHANGERATE-API");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Header
        System.out.printf("%-6s | %-25s | %s%n", "CODIGO", "NOMBRE", "PAIS/REGION");
        System.out.println("-".repeat(80));
        
        // Group currencies by region
        mostrarSeccion("AMERICAS", Arrays.asList(
            ExtendedCurrency.USD, ExtendedCurrency.CAD, ExtendedCurrency.MXN,
            ExtendedCurrency.ARS, ExtendedCurrency.BRL, ExtendedCurrency.COP,
            ExtendedCurrency.CLP, ExtendedCurrency.PEN, ExtendedCurrency.BOB,
            ExtendedCurrency.UYU, ExtendedCurrency.PYG
        ));
        
        mostrarSeccion("EUROPA", Arrays.asList(
            ExtendedCurrency.EUR, ExtendedCurrency.GBP, ExtendedCurrency.CHF,
            ExtendedCurrency.NOK, ExtendedCurrency.SEK, ExtendedCurrency.DKK,
            ExtendedCurrency.PLN, ExtendedCurrency.CZK, ExtendedCurrency.HUF,
            ExtendedCurrency.RON, ExtendedCurrency.BGN, ExtendedCurrency.HRK,
            ExtendedCurrency.RSD
        ));
        
        mostrarSeccion("ASIA", Arrays.asList(
            ExtendedCurrency.JPY, ExtendedCurrency.CNY, ExtendedCurrency.KRW,
            ExtendedCurrency.INR, ExtendedCurrency.SGD, ExtendedCurrency.HKD,
            ExtendedCurrency.TWD, ExtendedCurrency.THB, ExtendedCurrency.MYR,
            ExtendedCurrency.IDR, ExtendedCurrency.PHP, ExtendedCurrency.VND,
            ExtendedCurrency.PKR, ExtendedCurrency.LKR, ExtendedCurrency.BDT
        ));
        
        mostrarSeccion("MEDIO ORIENTE Y AFRICA", Arrays.asList(
            ExtendedCurrency.AED, ExtendedCurrency.SAR, ExtendedCurrency.QAR,
            ExtendedCurrency.KWD, ExtendedCurrency.BHD, ExtendedCurrency.OMR,
            ExtendedCurrency.ILS, ExtendedCurrency.TRY, ExtendedCurrency.EGP,
            ExtendedCurrency.ZAR, ExtendedCurrency.MAD, ExtendedCurrency.TND,
            ExtendedCurrency.DZD, ExtendedCurrency.NGN, ExtendedCurrency.KES,
            ExtendedCurrency.GHS
        ));
        
        mostrarSeccion("OCEANIA", Arrays.asList(
            ExtendedCurrency.AUD, ExtendedCurrency.NZD
        ));
        
        mostrarSeccion("OTROS", Arrays.asList(
            ExtendedCurrency.RUB, ExtendedCurrency.UAH, ExtendedCurrency.KZT,
            ExtendedCurrency.UZS, ExtendedCurrency.BYN
        ));
        
        System.out.println("=".repeat(80));
        System.out.printf("Total: %d monedas soportadas%n", ExtendedCurrency.values().length);
        System.out.println("=".repeat(80));
        System.out.println();
    }
    
    private void mostrarSeccion(String nombreRegion, List<ExtendedCurrency> monedas) {
        System.out.println();
        System.out.printf("--- %s ---%n", nombreRegion);
        
        for (ExtendedCurrency moneda : monedas) {
            System.out.println(moneda.getFormattedInfo());
        }
    }
    
    public void buscarMoneda(String codigo) {
        ExtendedCurrency moneda = ExtendedCurrency.findByCode(codigo);
        
        if (moneda != null) {
            System.out.println("\n=== INFORMACION DE LA MONEDA ===");
            System.out.printf("Codigo: %s%n", moneda.getCode());
            System.out.printf("Nombre: %s%n", moneda.getName());
            System.out.printf("Pais/Region: %s%n", moneda.getCountry());
            System.out.println("================================");
        } else {
            System.out.printf("No se encontro informacion para el codigo: %s%n", codigo);
            System.out.println("Use la opcion 9 para ver todas las monedas disponibles.");
        }
        System.out.println();
    }
    
    public void mostrarMonedasPorRegion(String region) {
        List<ExtendedCurrency> monedasFiltradas = Arrays.stream(ExtendedCurrency.values())
            .filter(currency -> currency.getCountry().toLowerCase().contains(region.toLowerCase()) ||
                               currency.getName().toLowerCase().contains(region.toLowerCase()))
            .sorted(Comparator.comparing(ExtendedCurrency::getCode))
            .collect(Collectors.toList());
            
        if (!monedasFiltradas.isEmpty()) {
            System.out.printf("\n=== MONEDAS ENCONTRADAS PARA: %s ===%n", region.toUpperCase());
            System.out.printf("%-6s | %-25s | %s%n", "CODIGO", "NOMBRE", "PAIS/REGION");
            System.out.println("-".repeat(60));
            
            monedasFiltradas.forEach(currency -> 
                System.out.println(currency.getFormattedInfo()));
                
            System.out.printf("\nTotal encontradas: %d%n", monedasFiltradas.size());
        } else {
            System.out.printf("No se encontraron monedas para: %s%n", region);
        }
        System.out.println();
    }
}