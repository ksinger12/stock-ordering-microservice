package com.trading.trader.service;

import com.crazzyghost.alphavantage.fundamentaldata.response.CompanyOverviewResponse;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.sector.response.SectorResponse;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;

public interface AlphaVantageService {

    TimeSeriesResponse getTimeSeriesData(String stockSymbol, Interval interval);

    CompanyOverviewResponse getStockCompanyOverview(String stockSymbol);

    SectorResponse getSectorInfo();
}
