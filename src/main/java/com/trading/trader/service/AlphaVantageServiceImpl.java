package com.trading.trader.service;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.fundamentaldata.response.CompanyOverviewResponse;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.sector.response.SectorResponse;
import com.crazzyghost.alphavantage.timeseries.response.QuoteResponse;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlphaVantageServiceImpl implements AlphaVantageService {
    @Autowired
    private AlphaVantage alphaVantage;

    @Override
    public TimeSeriesResponse getTimeSeriesData(String stockSymbol, Interval interval) {
        return alphaVantage
                .timeSeries()
                .intraday()
                .forSymbol(stockSymbol)
                .interval(interval)
                .outputSize(OutputSize.FULL)
                .fetchSync();
    }

    @Override
    public CompanyOverviewResponse getStockCompanyOverview(String stockSymbol) {
        return alphaVantage
                .fundamentalData()
                .companyOverview()
                .forSymbol(stockSymbol)
                .fetchSync();
    }

    @Override
    public SectorResponse getSectorInfo() {
        return alphaVantage.sector().fetchSync();
    }

    @Override
    public QuoteResponse getStockQuote(String stockSymbol) {
        return alphaVantage.timeSeries().quote().forSymbol(stockSymbol).fetchSync();
    }


}
