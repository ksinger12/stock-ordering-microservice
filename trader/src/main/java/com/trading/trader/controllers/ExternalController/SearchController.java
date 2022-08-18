package com.trading.trader.controllers.ExternalController;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Response;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@RestController
public class SearchController {

    // @GetMapping(value = "/search")
    public static Match getStockName(String keyword) {
        String url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + keyword +
                "&apikey=RBJRR2YCUMFQRRKZ";
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Match.class);
    }

    public static HttpStatus getResponseCode(RestTemplate temp, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        ResponseEntity<String> res = temp.exchange(url, HttpMethod.GET, entity, String.class);

        return res.getStatusCode();
    }
}
