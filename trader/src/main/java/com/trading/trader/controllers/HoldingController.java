package com.trading.trader.controllers;

import com.trading.trader.entities.Holding;
import com.trading.trader.service.HoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/holdings")
@CrossOrigin
public class HoldingController {

    @Autowired
    private HoldingService holdingService;
    //
    @GetMapping(value = "/")
    public Iterable<Holding> findAll() {
        return holdingService.getAllHoldings();
    }

    @DeleteMapping(value="/{id}")
    public void deleteHolding(@PathVariable("id") int id) {
        //TODO: must do try catch in case ticker doesn't exist!
        holdingService.deleteHolding(id);
    }

    @PostMapping(value="/")
    public void addHolding(@RequestBody Holding holding) {
        holdingService.addNewHolding(holding);
    }


}
