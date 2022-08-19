package com.trading.trader.controllers;

import com.trading.trader.entities.Holding;
import com.trading.trader.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cash")
@CrossOrigin
public class CashController {

    @Autowired
    private CashService cashService;

    @GetMapping(value="/cashAssetsValue")
    public String getCashAssets() {
        return String.valueOf(cashService.getCash());
    }

    //TODO: error handling for non number strings being input!
    @PostMapping(value="/setCashAssetsValue")
    public void setCashAssets(@RequestBody String initialCashAssets) {
        try {
            Double initialCashValue = Double.parseDouble(initialCashAssets.trim());
            cashService.setCash(Double.valueOf(initialCashAssets));
        } catch(NumberFormatException e) {
            System.out.println("A string that cannot be converted to a double provided");
        }
    }

    @PostMapping(value="/addCashAssetsValue")
    public void addCashAssets(@RequestBody String cashToAdd) {
        try {
            Double initialCashValue = Double.parseDouble(cashToAdd.trim());
            cashService.addCash(Double.valueOf(cashToAdd));
        } catch(NumberFormatException e) {
            System.out.println("A string that cannot be converted to a double provided");
        }
    }
}
