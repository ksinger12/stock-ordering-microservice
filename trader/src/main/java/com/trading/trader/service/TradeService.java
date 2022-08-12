package com.trading.trader.service;

public interface TradeService {
    Iterable<Trade> getAllTrades();
    Iterable<Trade> getAllTickerTrades(String tickerSymbol);
    Iterable<Trade> getTradesInDateRange(String startTime, String endTime);
    Trade addNewTrade(Trade trade);
    void deleteTrade(int id);
    void deleteTrade(Trade trade);
    Trade updateTrade(Trade trade);

}
