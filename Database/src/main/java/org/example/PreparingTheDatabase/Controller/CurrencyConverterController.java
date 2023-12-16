package org.example.PreparingTheDatabase.Controller;

import org.example.PreparingTheDatabase.Model.CurrencyConverter;
import org.example.PreparingTheDatabase.View.CurrencyConverterView;
import org.example.PreparingTheDatabase.DAO.CurrencyDao;

import java.util.List;

public class CurrencyConverterController {
    private CurrencyConverter currencyConverter;
    private CurrencyConverterView view;
    private CurrencyDao currencyDao;

    public CurrencyConverterController(CurrencyDao currencyDao, CurrencyConverter currencyConverter, CurrencyConverterView view) {
        this.currencyConverter = currencyConverter;
        this.view = view;
        this.currencyDao = currencyDao;

        if (currencyDao.isConnectionValid()) {
            currencyConverter.addCurrency("USD", "US Dollar", currencyDao.getConversionRateByAbbreviation("USD"));
            currencyConverter.addCurrency("EUR", "Euro", currencyDao.getConversionRateByAbbreviation("EUR"));
            currencyConverter.addCurrency("GBP", "British Pound", currencyDao.getConversionRateByAbbreviation("GBP"));
            currencyConverter.addCurrency("JPY", "Japanese Yen", currencyDao.getConversionRateByAbbreviation("JPY"));
            currencyConverter.addCurrency("CAD", "Canadian Dollar", currencyDao.getConversionRateByAbbreviation("CAD"));
            currencyConverter.addCurrency("AUD", "Australian Dollar", currencyDao.getConversionRateByAbbreviation("AUD"));
            currencyConverter.addCurrency("CHF", "Swiss Franc", currencyDao.getConversionRateByAbbreviation("CHF"));
            currencyConverter.addCurrency("CNY", "Chinese Yuan Renminbi", currencyDao.getConversionRateByAbbreviation("CNY"));
        } else {
            view.displayDatabaseConnectionError();
        }
    }

    public CurrencyConverterController(CurrencyConverter converter, CurrencyConverterView currencyConverterView) {
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
