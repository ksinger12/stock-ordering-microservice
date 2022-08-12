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
    @Column(name="symbol") private String symbol;
    @Column(name="dateTime") private String dateTime;
    @Column(name="orderType") private Integer orderType;
    @Column(name="quantity") private Integer quantity;
    @Column(name="price") private Double price;

    public Trade(int id, String symbol, String dateTime, Integer orderType, Integer quantity, Double price) {
        this.id = id;
        this.symbol = symbol;
        this.dateTime = dateTime;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
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
