package com.demo.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public final class CurrencyConvertorWebClient {


    public static ResponseEntity<String> toCurrency(String type) {
        RequestEntity<String> req = new RequestEntity<>(HttpMethod.GET,
                URI.create("http://www.floatrates.com/daily/" + type + ".json"));
        ResponseEntity<String> res = restTemplate.exchange(req, String.class);
        return restTemplate.exchange(req, String.class);
    }

    public static WebClien
}
