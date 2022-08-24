package com.trading.trader.controllers.ExternalController;

import com.crazzyghost.alphavantage.fundamentaldata.response.CompanyOverviewResponse;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.sector.response.SectorResponse;
import com.crazzyghost.alphavantage.timeseries.response.QuoteResponse;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import com.trading.trader.service.AlphaVantageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
@CrossOrigin
public class AlphaVantageController {

    @Autowired
    AlphaVantageServiceImpl alphaVantageService;

    @GetMapping(value = "/company/{stockTicker}/{timeStep}")
    public TimeSeriesResponse getStockData(@PathVariable("stockTicker") String ticker, @PathVariable("timeStep") String timeStep) {
        Interval interval = Interval.valueOf(timeStep);
        return alphaVantageService.getTimeSeriesData(ticker, interval);
    }

    @GetMapping(value = "/company/overview/{stockTicker}")
    public CompanyOverviewResponse getCompanyOverview(@PathVariable("stockTicker") String ticker) {
        return alphaVantageService.getStockCompanyOverview(ticker);
    }

    @GetMapping(value = "/company/quote/{stockTicker")
    public QuoteResponse getStockQuote(@PathVariable("stockTicker") String ticker) {
        return alphaVantageService.getStockQuote(ticker);
    }

    @GetMapping(value = "/sector")
    public SectorResponse getSectorInformation() {
        return alphaVantageService.getSectorInfo();
    }

}
