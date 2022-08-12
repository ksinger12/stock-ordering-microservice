package com.trading.trader.service;

import com.sun.xml.bind.v2.TODO;
import com.trading.trader.entities.Trade;
import com.trading.trader.repos.TradingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradingRepo tradeDao;
    @Override
    public Iterable<Trade> getAllTrades() {
        return tradeDao.findAll();
    }

    // TODO: proper implementation later!
    @Override
    public Iterable<Trade> getAllTickerTrades(String tickerSymbol) {
         return tradeDao.findAll();
    }

    // TODO: proper implementation later!
    @Override
    public Iterable<Trade> getTradesInDateRange(String startTime, String endTime) {
        return tradeDao.findAll();
    }

    @Override
    public Trade addNewTrade(Trade trade) {
        return null;
    }

    @Override
    public void deleteTrade(int id) {
        System.out.println();
    }

    @Override
    public void deleteTrade(Trade trade) {
        System.out.println();
    }

    @Override
    public Trade updateTrade(Trade trade) {
        return null;
    }
}
