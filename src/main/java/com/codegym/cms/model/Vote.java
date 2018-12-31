package com.codegym.cms.model;

public class Vote {
    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Vote() {
    }

    public Vote(String quantity) {
        this.quantity = quantity;
    }
}
