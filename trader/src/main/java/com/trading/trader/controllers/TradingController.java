package com.trading.trader.controllers;

import com.trading.trader.entities.Trade;
import com.trading.trader.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin
public class TradingController {

    @Autowired
    private TradeService tradeService;

    @GetMapping(value = "/")
    public Iterable<Trade> findAll() {
        return tradeService.getAllTrades();
    }

    @GetMapping(value = "/{tickerSymbol}")
    public Iterable<Trade> findAllByTickerSymbol(@PathVariable("tickerSymbol") String tickerSymbol) {
        return tradeService.getAllTickerTrades(tickerSymbol);
    }

    @PostMapping(value = "/")
    public void addTrade(@RequestBody Trade trade, String companyName) {
        tradeService.addNewTrade(trade, companyName);

        // TODO: probably need to do something with external api to indicate actual trade execution?
    }


    @DeleteMapping(value = "/{id}")
    public void deleteTrade(@PathVariable("id") int id) {
        tradeService.deleteTrade(id);
    }


}
