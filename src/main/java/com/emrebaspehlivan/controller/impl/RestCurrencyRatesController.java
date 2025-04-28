package com.emrebaspehlivan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emrebaspehlivan.controller.IRestCurrencyController;
import com.emrebaspehlivan.controller.RestBaseController;
import com.emrebaspehlivan.controller.RootEntity;
import com.emrebaspehlivan.dto.CurrencyRatesResponse;
import com.emrebaspehlivan.service.ICurrencyRatesService;

@RestController
@RequestMapping("/rest/api")
public class RestCurrencyRatesController extends RestBaseController implements IRestCurrencyController {

    @Autowired
    private ICurrencyRatesService currencyRatesService;

    @GetMapping("/currency-rates")
    @Override
    public RootEntity<CurrencyRatesResponse> getCurrencyRates(@RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }

}
