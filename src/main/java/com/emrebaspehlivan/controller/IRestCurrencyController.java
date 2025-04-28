package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.CurrencyRatesResponse;

public interface IRestCurrencyController {

    public RootEntity<CurrencyRatesResponse> getCurrencyRates(String startDate, String endDate);
}
