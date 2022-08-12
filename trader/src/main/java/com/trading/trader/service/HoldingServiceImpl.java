package com.trading.trader.service;

import com.trading.trader.entities.Holding;
import com.trading.trader.repos.HoldingRepo;

public class HoldingServiceImpl implements HoldingService {

    private HoldingRepo holdingDao;

    @Override
    public Iterable<Holding> getAllHoldings() {
        return holdingDao.findAll();
    }

    // TODO: do proper implementation
    @Override
    public Iterable<Holding> getAllTickerHoldings(String tickerSymbol) {
        return holdingDao.findAll();
    }

    // TODO: do proper implementation
    @Override
    public Holding addNewHolding(Holding holding) {
        return holding;
    }

    // TODO: implement later
    @Override
    public void deleteHolding(int id) {
        System.out.println("remove holding by id");
    }

    // TODO: implement later
    @Override
    public void deleteHolding(Holding Holding) {
        System.out.println("remove holding by id");
    }

    @Override
    public Holding updateHolding(Holding Holding) {
        return null;
    }
}
