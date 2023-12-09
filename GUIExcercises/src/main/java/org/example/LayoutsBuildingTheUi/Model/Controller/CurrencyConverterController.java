package org.example.LayoutsBuildingTheUi.Model.Controller;

import java.util.List;
import org.example.LayoutsBuildingTheUi.Model.Model.CurrencyConverter;
import org.example.LayoutsBuildingTheUi.Model.View.CurrencyConverterView;

public class CurrencyConverterController {
    private CurrencyConverter currencyConverter;
    private CurrencyConverterView view;

    public CurrencyConverterController(CurrencyConverter currencyConverter, CurrencyConverterView view) {
        this.currencyConverter = currencyConverter;
        this.view = view;
        currencyConverter.addCurrency("USD", "US Dollar", 1.0);
        currencyConverter.addCurrency("EUR", "Euro", 0.93);
        currencyConverter.addCurrency("GBP", "British Pound", 0.8);
        currencyConverter.addCurrency("JPY", "Japanese Yen", 145);
        currencyConverter.addCurrency("CAD", "Canadian Dollar", 1.3589);
    }

    public String convertCurrency(String fromCurrency, String toCurrency, double amount) {
        return currencyConverter.convertCurrency(fromCurrency, toCurrency, amount);
    }

    public List<String> getAllCurrencies() {
        return currencyConverter.getAllCurrencies();
    }

    public static void main(String[] args) {
        CurrencyConverterView.launch(CurrencyConverterView.class);
    }
}
