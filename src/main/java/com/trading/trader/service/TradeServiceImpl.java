package com.trading.trader.service;

import com.trading.trader.entities.Cash;
import com.trading.trader.entities.Holding;
import com.trading.trader.entities.Trade;
import com.trading.trader.repos.CashRepo;
import com.trading.trader.repos.HoldingRepo;
import com.trading.trader.repos.TradingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradingRepo tradeDao;
    @Autowired
    private HoldingRepo holdingDao;

    @Autowired
    private CashRepo cashDao;
    @Override
    public Iterable<Trade> getAllTrades() {
        return tradeDao.findAll();
    }

    @Override
    public Iterable<Trade> getAllTickerTrades(String tickerSymbol) {
        return tradeDao.findByTickerSymbol(tickerSymbol);
    }

    // TODO: proper implementation later!
    @Override
    public Iterable<Trade> getTradesInDateRange(String startTime, String endTime) {
        return tradeDao.findAll();
    }

    @Override
    public String addNewTrade(Trade trade) {
        // perform write operation on holding table
        String curTickerSymbol = trade.gettickerSymbol();
        String orderType = trade.getOrderType();
        Holding updatedHolding;
        Cash updatedCash;


        // TODO: giant try catch for ensuring proper user input? or just ensure on client side
        if (!orderType.equals("BUY") && !orderType.equals("SELL") || trade.getQuantity() < 1) {
            return "invalid trade given";
        }

        // need to make sure person has sufficient funds if buying
        // perform operations on cash table
        double purchaseCost = trade.getQuantity()*trade.getPrice();
        Optional<Cash> cashToBeUpdated = cashDao.findById(1);
        if (cashToBeUpdated.isPresent()) {
            double cashInPossession = cashToBeUpdated.get().getCash();
            if (orderType.equals("BUY") && cashInPossession < purchaseCost) {
                return "insufficient funds for purchase";
            } else if (orderType.equals("BUY") && cashInPossession >= purchaseCost){
                updatedCash = cashToBeUpdated.get();
                updatedCash.setCash(cashInPossession - purchaseCost);
                cashDao.save(updatedCash);
            }
        } else {
            return "cash table non-existent";
        }


        // find the appropriate holding by tickersymbol if it exists
        Optional<Holding> holdingToBeUpdated = holdingDao.findByTickerSymbol(curTickerSymbol);

        // update existing trade
        if (holdingToBeUpdated.isPresent()) {
            int holdingQuantity = holdingToBeUpdated.get().getNumberOfShares();

            if (orderType.equals("BUY")) {
                holdingQuantity += trade.getQuantity();
            } else if (orderType.equals("SELL")) {
                holdingQuantity -= trade.getQuantity();

                if (holdingQuantity < 0) {
                    return "not enough shares to sell";
                }
                // update cash in possession
                double cashInPossession = cashToBeUpdated.get().getCash();
                updatedCash = cashToBeUpdated.get();
                updatedCash.setCash(cashInPossession + trade.getQuantity()*trade.getPrice());
                cashDao.save(updatedCash);
            }

            // update the appropriate holding using share quantity info
            updatedHolding = holdingToBeUpdated.get();

            updatedHolding.setNumberOfShares(holdingQuantity);

        } else {
            // create a new holding for the trade
            if (orderType.equals("SELL")) {
                return "cannot sell shares of non-existent holding";
            }

            updatedHolding = new Holding(
                    curTickerSymbol,
                    trade.getCompanyName(),
                    trade.getQuantity()
            );

        }

        if (updatedHolding.getNumberOfShares() == 0) {
            holdingDao.delete(updatedHolding);
        } else {
            holdingDao.save(updatedHolding);
        }



        tradeDao.save(trade);

        return "order placed successfully";


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
