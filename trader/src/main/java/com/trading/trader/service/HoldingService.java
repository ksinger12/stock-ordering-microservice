package com.trading.trader.service;

import com.trading.trader.entities.Holding;

public interface HoldingService {
    Iterable<Holding> getAllHoldings();
    Iterable<Holding> getAllTickerHoldings(String tickerSymbol);
    Holding addNewHolding(Holding Holding);
    void deleteHolding(int id);
    void deleteHolding(Holding Holding);
    Holding updateHolding(Holding Holding);
}
