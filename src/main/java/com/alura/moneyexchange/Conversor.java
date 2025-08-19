package com.alura.moneyexchange;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Conversor {
    private final CurrencyConverter currencyConverter;
    private final Scanner scanner;
    private final CurrencyInfoService currencyInfoService;

    public Conversor() {
        this.currencyConverter = new CurrencyConverter();
        this.scanner = new Scanner(System.in);
        this.currencyInfoService = new CurrencyInfoService();
    }

    public void exibirMenu() {
        System.out.println("*".repeat(50));
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println();
        System.out.println("1) Dolar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dolar");
        System.out.println("3) Dolar =>> Real brasileno");
        System.out.println("4) Real brasileno =>> Dolar");
        System.out.println("5) Dolar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dolar");
        System.out.println("7) Ver historial de conversiones");
        System.out.println("8) Ver monedas soportadas");
        System.out.println("9) Buscar informacion de moneda");
        System.out.println("10) Salir");
        System.out.println("Elija una opcion valida:");
        System.out.println("*".repeat(50));
    }

    public void iniciar() {
        boolean continuar = true;
        
        while (continuar) {
            exibirMenu();
            
            try {
                int opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        realizarConversion(Currency.USD, Currency.ARS);
                        break;
                    case 2:
                        realizarConversion(Currency.ARS, Currency.USD);
                        break;
                    case 3:
                        realizarConversion(Currency.USD, Currency.BRL);
                        break;
                    case 4:
                        realizarConversion(Currency.BRL, Currency.USD);
                        break;
                    case 5:
                        realizarConversion(Currency.USD, Currency.COP);
                        break;
                    case 6:
                        realizarConversion(Currency.COP, Currency.USD);
                        break;
                    case 7:
                        mostrarHistorial();
                        break;
                    case 8:
                        currencyInfoService.mostrarMonedasSoportadas();
                        break;
                    case 9:
                        buscarMoneda();
                        break;
                    case 10:
                        continuar = false;
                        System.out.println("¡Gracias por usar el conversor de monedas!");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, seleccione una opcion del 1 al 10.");
                }
                
                if (continuar && opcion != 7 && opcion != 8 && opcion != 9) {
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                } else if (continuar && (opcion == 8 || opcion == 9)) {
                    System.out.println("Presione Enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                }
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }

    private void realizarConversion(Currency desde, Currency hacia) {
        try {
            System.out.printf("Ingresa el valor que deseas convertir de %s a %s: ", 
                    desde.getName(), hacia.getName());
            double cantidad = scanner.nextDouble();
            
            if (cantidad <= 0) {
                System.out.println("Por favor, ingrese un valor positivo.");
                return;
            }
            
            System.out.println("Consultando tasas de cambio...");
            ConversionResult resultado = currencyConverter.convertCurrency(desde, hacia, cantidad);
            
            System.out.println();
            System.out.println(resultado.getFormattedResult());
            System.out.println();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void mostrarHistorial() {
        List<ConversionResult> historial = currencyConverter.getConversionHistory();
        
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("\n--- HISTORIAL DE CONVERSIONES ---");
            for (int i = historial.size() - 1; i >= 0; i--) {
                System.out.println((historial.size() - i) + ". " + historial.get(i));
            }
            System.out.println("--- FIN DEL HISTORIAL ---\n");
        }
        
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }

    private void buscarMoneda() {
        try {
            System.out.println("\n=== BUSCAR INFORMACION DE MONEDA ===");
            System.out.print("Ingrese el codigo de la moneda (ej: USD, EUR, JPY): ");
            scanner.nextLine(); // Consume the newline
            String codigo = scanner.nextLine().trim().toUpperCase();
            
            if (codigo.isEmpty()) {
                System.out.println("Por favor ingrese un codigo valido.");
                return;
            }
            
            currencyInfoService.buscarMoneda(codigo);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}