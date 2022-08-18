package com.trading.trader.service;

import com.trading.trader.entities.Cash;
import com.trading.trader.repos.CashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashServiceImpl implements CashService {
    @Autowired
    private CashRepo cashDao;


    @Override
    public Double getCash() {
        Optional<Cash> cash = cashDao.findById(1);
        return cash.get().getCash();
    }

    @Override
    public void setCash(Double cashValue) {
        Optional<Cash> cashToSet = cashDao.findById(1);
        Cash toSet;
        if (cashToSet.isPresent()) {
            toSet = cashToSet.get();
            toSet.setCash(cashValue);
        } else {
            toSet = new Cash(cashValue);
        }
        cashDao.save(toSet);
    }
    @Override
    public void addCash(Double cashToAdd) {
        Optional<Cash> cash = cashDao.findById(1);
        Cash updatedCash = cash.get();
        double currentCashValue = updatedCash.getCash();
        updatedCash.setCash(currentCashValue + cashToAdd);
        cashDao.save(updatedCash);
    }

    @Override
    public void reduceCash(Double cashToSubtract) {
        Optional<Cash> cash = cashDao.findById(1);
        Cash updatedCash = cash.get();
        double currentCashValue = updatedCash.getCash();
        updatedCash.setCash(currentCashValue - cashToSubtract);
        cashDao.save(updatedCash);
    }
}
