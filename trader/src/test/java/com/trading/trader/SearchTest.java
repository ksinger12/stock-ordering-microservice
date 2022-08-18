package com.trading.trader;


import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import static com.trading.trader.controllers.ExternalController.SearchController.getResponseCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    @Test
    public void searchStatusCodeTest() {
        String keyword = "Microsoft";
        HttpStatus expected = HttpStatus.OK;

        String url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + keyword +
                "&apikey=RBJRR2YCUMFQRRKZ";
        RestTemplate restTemplate = new RestTemplate();

        HttpStatus actual = getResponseCode(restTemplate, url);

        assertEquals(expected, actual);
    }

}
