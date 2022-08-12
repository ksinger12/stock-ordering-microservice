package com.trading.trader.service;

import com.trading.trader.entities.Trade;

public class TradeServiceImpl implements TradeService {
    @Override
    public Iterable<Trade> getAllTrades() {
        return null;
    }

    @Override
    public Iterable<Trade> getAllTickerTrades(String tickerSymbol) {
        return null;
    }

    @Override
    public Iterable<Trade> getTradesInDateRange(String startTime, String endTime) {
        return null;
    }

    @Override
    public Trade addNewTrade(Trade trade) {
        return null;
    }

    @Override
    public void deleteTrade(int id) {

    }

    @Override
    public void deleteTrade(Trade trade) {

    }

    @Override
    public Trade updateTrade(Trade trade) {
        return null;
    }
}
