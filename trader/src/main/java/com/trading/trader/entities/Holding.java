package com.trading.trader.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table(name="holdings")
public class Holding implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // add attributes for all the remaining properties
    @Column(name="tickerSymbol") private String tickerSymbol;
    @Column(name="companyName") private String companyName;
    @Column(name="numberOfShares") private Integer numberOfShares;
    @Column(name="portfolioStake") private Double portfolioStake;

    public Holding(String tickerSymbol, String companyName, Integer numberOfShares, Double portfolioStake) {
        this.tickerSymbol = tickerSymbol;
        this.companyName = companyName;
        this.numberOfShares = numberOfShares;
        this.portfolioStake = portfolioStake;
    }

    public Holding() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getPortfolioStake() {
        return portfolioStake;
    }

    public void setPortfolioStake(Double portfolioStake) {
        this.portfolioStake = portfolioStake;
    }
}
