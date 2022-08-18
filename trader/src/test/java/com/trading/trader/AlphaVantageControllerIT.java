package com.trading.trader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlphaVantageControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void stockTickerAndtimeStep_getStockData_returnTimeSeriesResponseData() throws Exception {
        // Initialize
        String stockTicker = "IBM";
        String timeStep = "FIVE_MIN";
        String path = "/api/data/company/" + stockTicker + "/" + timeStep;

        // Execution
        ResponseEntity<Object> response = template.getForEntity(path, Object.class);

        // Assertion
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void stockTicker_getCompanyOverview_returnCompanyOverviewResponseData() throws Exception {
        // Initialize
        String stockTicker = "IBM";
        String path = "/api/data/company/overview/" + stockTicker;

        // Execution
        ResponseEntity<Object> response = template.getForEntity(path, Object.class);

        // Assertion
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void apiCall_getSectorInformation_returnCompanyOverviewResponseData() throws Exception {
        // Initialize
        String path = "/api/data/sector";

        // Execution
        ResponseEntity<Object> response = template.getForEntity(path, Object.class);

        // Assertion
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}