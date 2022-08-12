package com.trading.trader.repos;

import com.trading.trader.entities.Holding;

public interface HoldingRepo {
    public Iterable<Holding> findAll();
    public Iterable<Holding> findByTickerSymbol(String tickerSymbol);
}
