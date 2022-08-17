package com.trading.trader.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="trades")
public class Trade implements Serializable {


    // add an attribute specifying a column for the id property
    // add attributes to ensure that the id column is automantically generated
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // add attributes for all the remaining properties
    @Column(name="tickerSymbol") private String tickerSymbol;
    @Column(name="dateEntered") private String dateEntered;
    @Column(name="orderType") private String orderType;
    @Column(name="quantity") private Integer quantity;
    @Column(name="price") private Double price;

    public Trade(int id, String tickerSymbol, String dateEntered, String orderType, Integer quantity, Double price) {
        this.id = id;
        this.tickerSymbol = tickerSymbol;
        this.dateEntered = dateEntered;
        this.orderType = orderType;
        this.quantity = quantity;
        this.price = price;
    }

    public Trade() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettickerSymbol() {
        return tickerSymbol;
    }

    public void settickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getdateEntered() {
        return dateEntered;
    }

    public void setdateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
