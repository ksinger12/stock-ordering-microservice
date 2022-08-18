package com.trading.trader.repos;

import com.trading.trader.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingRepo extends JpaRepository<Trade, Integer> {
    public Iterable<Trade> findByTickerSymbol(String symbol);
}
