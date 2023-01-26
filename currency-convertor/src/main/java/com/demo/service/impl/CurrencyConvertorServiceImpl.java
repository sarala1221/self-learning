package com.demo.service.impl;

import com.demo.service.CurrencyConvertorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class CurrencyConvertorRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> toCurrency(String type) {
        RequestEntity<String> req = new RequestEntity<>(HttpMethod.GET,
                URI.create("http://www.floatrates.com/daily/" + type + ".json"));
        ResponseEntity<String> res = restTemplate.exchange(req, String.class);
        return restTemplate.exchange(req, String.class);
    }
}
