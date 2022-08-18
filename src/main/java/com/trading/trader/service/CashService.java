package com.trading.trader.service;

import com.trading.trader.entities.Cash;

import java.util.Optional;

public interface CashService {
    Double getCash();

    void setCash(Double cash);
    void addCash(Double cash);
    void reduceCash(Double cash);
}
