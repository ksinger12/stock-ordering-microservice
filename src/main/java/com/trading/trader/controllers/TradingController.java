package com.trading.trader.controllers;

import com.trading.trader.entities.Trade;
import com.trading.trader.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public void addTrade(@RequestParam("tickerSymbol") String tickerSymbol,
                         @RequestParam("companyName") String companyName,
                         @RequestParam("orderType") String orderType,
                         @RequestParam("quantity") Integer quantity,
                         @RequestParam("price") Double price
                         ) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        String currentTimeString = dtf.format(currentTime);

        Trade tradeToAdd = new Trade(
                tickerSymbol,
                companyName,
                currentTimeString,
                orderType,
                quantity,
                price
        );
        tradeService.addNewTrade(tradeToAdd);

        //TODO: each trade will affect the holdings, so should implement that somehow
    }



}
