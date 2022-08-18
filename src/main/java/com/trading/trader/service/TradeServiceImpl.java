package com.trading.trader.service;

import com.trading.trader.entities.Holding;
import com.trading.trader.entities.Trade;
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


    //TODO: doing a trade here should also be writing to the holdings table
    // adds a trade to the trades table and edits holding table to reflect changes
    // returns a string indicating whether the trade was executed successfully or not
    @Override
    public String addNewTrade(Trade trade, String companyName) {
        // perform write operation on holding table
        String curTickerSymbol = trade.gettickerSymbol();
        String orderType = trade.getOrderType();
        Holding updatedHolding;

        // TODO: giant try catch for ensuring proper user input? or just ensure on client side
        if (!orderType.equals("BUY") && !orderType.equals("SELL") || trade.getQuantity() < 1) {
            return "invalid trade given";
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
            }

            // update the appropriate holding using share quantity info
            holdingToBeUpdated.get().setNumberOfShares(holdingQuantity);
            updatedHolding = holdingToBeUpdated.get();

        } else {
            // create a new holding for the trade
            if (orderType.equals("SELL")) {
                return "cannot sell shares of non-existent holding";
            }

            updatedHolding = new Holding(
                    curTickerSymbol,
                    companyName,
                    trade.getQuantity(),
                    0.24 // dummy value for now. should create an account class or something
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
