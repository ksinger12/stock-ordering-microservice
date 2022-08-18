package com.trading.trader.service;

import com.trading.trader.entities.Holding;

public interface HoldingService {
    Iterable<Holding> getAllHoldings();
    //    Iterable<Holding> getAllTickerHoldings(String tickerSymbol);
    Holding addNewHolding(Holding Holding);
    //    void editHolding(String tickerSymbol);
    void deleteHolding(int id);
//    void deleteHolding(String tickerSymbol);
//    void deleteHolding(Holding Holding);
//    Holding updateHolding(Holding Holding);
}
