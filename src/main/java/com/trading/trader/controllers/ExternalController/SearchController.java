package com.trading.trader.controllers.ExternalController;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin
public class SearchController {

    @GetMapping(value = "/search/{stockName}")
    public static Object getStockName(@PathVariable("stockName") String keyword) {
        String url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + keyword +
                "&apikey=RBJRR2YCUMFQRRKZ";
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Object.class);
    }

    public static HttpStatus getResponseCode(RestTemplate temp, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<String> res = temp.exchange(url, HttpMethod.GET, entity, String.class);

        return res.getStatusCode();
    }
}
