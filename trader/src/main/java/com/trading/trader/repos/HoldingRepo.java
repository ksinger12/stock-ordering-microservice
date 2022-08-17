package com.trading.trader.repos;

import com.trading.trader.entities.Holding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingRepo extends JpaRepository<Holding, Integer> {
//    public Iterable<Holding> findAll();
//    public Iterable<Holding> findByTickerSymbol(String tickerSymbol);
}
