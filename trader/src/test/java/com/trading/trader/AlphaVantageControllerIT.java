package com.trading.trader;

import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlphaVantageControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void stockTickerAndtimeStep_getStockData_returnTimeSeriesResponse() throws Exception {
        // Initialize
        String stockTicker = "IBM";
        String timeStep = "FIVE_MIN";
        String path = "/api/data/company/"+stockTicker+"/"+timeStep;


        ResponseEntity<TimeSeriesResponse> response = template.getForEntity(path, TimeSeriesResponse.class);
//        ObjectMapper mapper = new ObjectMapper();
//        ResponseEntity<JsonNode> response = template.getForEntity(path, JsonNode.class);
//        TimeSeriesResponse pojo = mapper.convertValue(response.getBody(), new TypeReference<TimeSeriesResponse>(){});
        //TimeSeriesResponse timeSeriesResponse = new TimeSeriesResponse();

        System.out.println("");
//        assertThat(response.getBody());
    }

}