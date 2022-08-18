package com.trading.trader.service;

import com.trading.trader.entities.Trade;

public interface TradeService {
    Iterable<Trade> getAllTrades();
    Iterable<Trade> getAllTickerTrades(String tickerSymbol);
    Iterable<Trade> getTradesInDateRange(String startTime, String endTime);
    String addNewTrade(Trade trade, String companyName);
    void deleteTrade(int id);
    void deleteTrade(Trade trade);
    Trade updateTrade(Trade trade);

}
