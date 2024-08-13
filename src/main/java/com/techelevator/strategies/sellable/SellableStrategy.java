package com.techelevator.strategies.sellable;

import com.techelevator.strategies.nurturable.NuturableStrategy;

public abstract class SellableStrategy {
    private double sellingPrice;
    protected boolean isSold;

    protected SellableStrategy(double sellingPrice){
        this.sellingPrice = sellingPrice;
    }

    public abstract double sell(NuturableStrategy.State state);

    public abstract double getOffer();

    public boolean isSold() {
        return isSold;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
}
