package com.trading.trader.service;

import com.trading.trader.entities.Holding;
import com.trading.trader.repos.HoldingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoldingServiceImpl implements HoldingService {

    @Autowired
    private HoldingRepo holdingDao;

    @Override
    public Iterable<Holding> getAllHoldings() {
        return holdingDao.findAll();
    }

    // TODO: do proper implementation
//    @Override
//    public Iterable<Holding> getAllTickerHoldings(String tickerSymbol) {
//        return holdingDao.findAll();
//    }

    // TODO: do proper implementation
    @Override
    public Holding addNewHolding(Holding holding) {
        return holdingDao.save(holding);
    }
    //
//    @Override
//    public void editHolding(String tickerSymbol) {
//        System.out.println("test");
//    }
//
//    // TODO: implement later
//    @Override
//    public void deleteHolding(int id) {
//        System.out.println("remove holding by id");
//    }
//
    @Override
    public void deleteHolding(int id) {
        Optional<Holding> toBeDeleted = holdingDao.findById(id);
        if (toBeDeleted.isPresent()) {
            holdingDao.delete(toBeDeleted.get());
        }
    }
//
//    // TODO: implement later
//    @Override
//    public void deleteHolding(Holding Holding) {
//        System.out.println("remove holding by the whole thing");
//    }
//
//    @Override
//    public Holding updateHolding(Holding Holding) {
//        return null;
//    }
}
