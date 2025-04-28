package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {

    CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);

}