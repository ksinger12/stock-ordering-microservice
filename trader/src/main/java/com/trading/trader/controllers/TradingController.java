package com.trading.trader.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradingController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
