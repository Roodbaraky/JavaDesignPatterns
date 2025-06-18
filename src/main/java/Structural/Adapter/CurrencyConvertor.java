/*
 * (c) Midland Software Limited 2025
 * Name     : CurrencyConvertor.java
 * Author   : RoodbarakyK
 * Date     : 18 Jun 2025
 */
package Structural.Adapter;

import java.util.EnumMap;
import java.util.Map;

public class CurrencyConvertor {
    private static final Map<Currency, Double> currencyToMultiplier = new EnumMap<>(Currency.class);

    static {
        currencyToMultiplier.put(Currency.GBP, 1.345);   // British Pound
        currencyToMultiplier.put(Currency.EUR, 1.151);   // Euro
        currencyToMultiplier.put(Currency.JPY, 0.00690); // Japanese Yen
        currencyToMultiplier.put(Currency.AUD, 0.650);   // Australian Dollar
        currencyToMultiplier.put(Currency.CAD, 0.732);   // Canadian Dollar
        currencyToMultiplier.put(Currency.CHF, 1.122);   // Swiss Franc
        currencyToMultiplier.put(Currency.CNY, 0.138);   // Chinese Yuan
        currencyToMultiplier.put(Currency.SEK, 0.095);   // Swedish Krona
        currencyToMultiplier.put(Currency.NZD, 0.610);   // New Zealand Dollar
        currencyToMultiplier.put(Currency.MXN, 0.055);   // Mexican Peso
        currencyToMultiplier.put(Currency.SGD, 0.739);   // Singapore Dollar
        currencyToMultiplier.put(Currency.HKD, 0.128);   // Hong Kong Dollar
        currencyToMultiplier.put(Currency.NOK, 0.093);   // Norwegian Krone
        currencyToMultiplier.put(Currency.KRW, 0.00072); // South Korean Won
        currencyToMultiplier.put(Currency.TRY, 0.031);   // Turkish Lira
        currencyToMultiplier.put(Currency.INR, 0.012);   // Indian Rupee
        currencyToMultiplier.put(Currency.RUB, 0.011);   // Russian Ruble
        currencyToMultiplier.put(Currency.ZAR, 0.055);   // South African Rand
        currencyToMultiplier.put(Currency.BRL, 0.185);   // Brazilian Real
    }

    public static double convertToDollars(Currency currency, double amount) {
        return amount * currencyToMultiplier.get(currency);
    }
}
