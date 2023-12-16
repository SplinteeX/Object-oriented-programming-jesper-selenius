package org.example.PreparingTheDatabase.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Currency> currencies = new HashMap<>();

    public void addCurrency(String abbreviation, String name, double conversionRate) {
        currencies.put(abbreviation, new Currency(name, conversionRate));
    }

    public String convertCurrency(String fromCurrency, String toCurrency, double amount) {
        if (!currencies.containsKey(fromCurrency) || !currencies.containsKey(toCurrency)) {
            return "Invalid currency";
        }
        Currency from = currencies.get(fromCurrency);
        Currency to = currencies.get(toCurrency);
        double convertedAmount = amount * (to.getConversionRate() / from.getConversionRate());
        return String.format("%.2f %s = %.2f %s", amount, from.getName(), convertedAmount, to.getName());
    }

    public List<String> getAllCurrencies() {
        return new ArrayList<>(currencies.keySet());
    }
}
