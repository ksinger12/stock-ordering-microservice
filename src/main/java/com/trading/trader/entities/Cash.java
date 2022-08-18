package com.trading.trader.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cash")
public class Cash implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="cash")
    private Double cash = 0.0;

    public Cash(Double cash) {
        this.cash = cash;
    }

    public Cash() {
    }


    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
}
