package com.alura.moneyexchange;

public enum Currency {
    USD("USD", "Dolar estadounidense"),
    ARS("ARS", "Peso argentino"),
    BRL("BRL", "Real brasileno"),
    COP("COP", "Peso colombiano"),
    CLP("CLP", "Peso chileno"),
    BOB("BOB", "Boliviano boliviano");

    private final String code;
    private final String name;

    Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}