package com.trading.trader.controllers;

import com.trading.trader.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin
public class TradingController {

    @Autowired
    private TradeService tradeService;



    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


}
