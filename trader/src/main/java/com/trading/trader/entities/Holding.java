package com.trading.trader.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table(name="holdings")
public class Holding implements Serializable {
<<<<<<< Updated upstream
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
=======
>>>>>>> Stashed changes

    // add attributes for all the remaining properties
    @Column(name="symbol") private String symbol;
    @Column(name="companyName") private String companyName;
    @Column(name="numberOfShares") private Integer numberOfShares;
    @Column(name="portfolioStake") private Double portfolioStake;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
