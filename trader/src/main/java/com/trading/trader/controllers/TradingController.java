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



//    @GetMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }

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

        //TODO: each trade will affect the holdings, so should implement that somehow
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTrade(@PathVariable("id") int id) {
        tradeService.deleteTrade(id);
    }


}
