package com.alura.moneyexchange;

public enum ExtendedCurrency {
    // Americas
    USD("USD", "US Dollar", "United States"),
    CAD("CAD", "Canadian Dollar", "Canada"),
    MXN("MXN", "Mexican Peso", "Mexico"),
    ARS("ARS", "Argentine Peso", "Argentina"),
    BRL("BRL", "Brazilian Real", "Brazil"),
    COP("COP", "Colombian Peso", "Colombia"),
    CLP("CLP", "Chilean Peso", "Chile"),
    PEN("PEN", "Peruvian Sol", "Peru"),
    BOB("BOB", "Bolivian Boliviano", "Bolivia"),
    UYU("UYU", "Uruguayan Peso", "Uruguay"),
    PYG("PYG", "Paraguayan Guarani", "Paraguay"),
    
    // Europe
    EUR("EUR", "Euro", "European Union"),
    GBP("GBP", "British Pound", "United Kingdom"),
    CHF("CHF", "Swiss Franc", "Switzerland"),
    NOK("NOK", "Norwegian Krone", "Norway"),
    SEK("SEK", "Swedish Krona", "Sweden"),
    DKK("DKK", "Danish Krone", "Denmark"),
    PLN("PLN", "Polish Zloty", "Poland"),
    CZK("CZK", "Czech Koruna", "Czech Republic"),
    HUF("HUF", "Hungarian Forint", "Hungary"),
    RON("RON", "Romanian Leu", "Romania"),
    BGN("BGN", "Bulgarian Lev", "Bulgaria"),
    HRK("HRK", "Croatian Kuna", "Croatia"),
    RSD("RSD", "Serbian Dinar", "Serbia"),
    
    // Asia
    JPY("JPY", "Japanese Yen", "Japan"),
    CNY("CNY", "Chinese Yuan", "China"),
    KRW("KRW", "South Korean Won", "South Korea"),
    INR("INR", "Indian Rupee", "India"),
    SGD("SGD", "Singapore Dollar", "Singapore"),
    HKD("HKD", "Hong Kong Dollar", "Hong Kong"),
    TWD("TWD", "New Taiwan Dollar", "Taiwan"),
    THB("THB", "Thai Baht", "Thailand"),
    MYR("MYR", "Malaysian Ringgit", "Malaysia"),
    IDR("IDR", "Indonesian Rupiah", "Indonesia"),
    PHP("PHP", "Philippine Peso", "Philippines"),
    VND("VND", "Vietnamese Dong", "Vietnam"),
    PKR("PKR", "Pakistani Rupee", "Pakistan"),
    LKR("LKR", "Sri Lankan Rupee", "Sri Lanka"),
    BDT("BDT", "Bangladeshi Taka", "Bangladesh"),
    
    // Middle East & Africa
    AED("AED", "UAE Dirham", "United Arab Emirates"),
    SAR("SAR", "Saudi Riyal", "Saudi Arabia"),
    QAR("QAR", "Qatari Riyal", "Qatar"),
    KWD("KWD", "Kuwaiti Dinar", "Kuwait"),
    BHD("BHD", "Bahraini Dinar", "Bahrain"),
    OMR("OMR", "Omani Rial", "Oman"),
    ILS("ILS", "Israeli Shekel", "Israel"),
    TRY("TRY", "Turkish Lira", "Turkey"),
    EGP("EGP", "Egyptian Pound", "Egypt"),
    ZAR("ZAR", "South African Rand", "South Africa"),
    MAD("MAD", "Moroccan Dirham", "Morocco"),
    TND("TND", "Tunisian Dinar", "Tunisia"),
    DZD("DZD", "Algerian Dinar", "Algeria"),
    NGN("NGN", "Nigerian Naira", "Nigeria"),
    KES("KES", "Kenyan Shilling", "Kenya"),
    GHS("GHS", "Ghanaian Cedi", "Ghana"),
    
    // Oceania
    AUD("AUD", "Australian Dollar", "Australia"),
    NZD("NZD", "New Zealand Dollar", "New Zealand"),
    
    // Other Notable Currencies
    RUB("RUB", "Russian Ruble", "Russia"),
    UAH("UAH", "Ukrainian Hryvnia", "Ukraine"),
    KZT("KZT", "Kazakhstani Tenge", "Kazakhstan"),
    UZS("UZS", "Uzbekistani Som", "Uzbekistan"),
    BYN("BYN", "Belarusian Ruble", "Belarus");

    private final String code;
    private final String name;
    private final String country;

    ExtendedCurrency(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getFormattedInfo() {
        return String.format("%-4s | %-25s | %s", code, name, country);
    }

    public static ExtendedCurrency findByCode(String code) {
        for (ExtendedCurrency currency : values()) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency;
            }
        }
        return null;
    }
}