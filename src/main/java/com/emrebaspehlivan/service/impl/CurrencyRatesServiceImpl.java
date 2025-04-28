package com.emrebaspehlivan.service.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emrebaspehlivan.dto.CurrencyRatesResponse;
import com.emrebaspehlivan.exception.BaseException;
import com.emrebaspehlivan.exception.ErrorMessage;
import com.emrebaspehlivan.exception.MessageType;
import com.emrebaspehlivan.service.ICurrencyRatesService;

@Service
public class CurrencyRatesServiceImpl implements ICurrencyRatesService {

    @Override
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {

        String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
        String series = "TP.DK.USD.A";
        String type = "json";

        String endPoint = rootURL + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type="
                + type;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key", "YUarsFZs1H");

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CurrencyRatesResponse> responseEntity = restTemplate.exchange(endPoint, HttpMethod.GET,
                    httpEntity, new ParameterizedTypeReference<CurrencyRatesResponse>() {
                    });
            return responseEntity.getBody();
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.CURRENCY_RATE_IS_OCCURED, e.getMessage()));
        }

    }
}
