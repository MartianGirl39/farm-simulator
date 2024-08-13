package com.techelevator.strategies.sellable;

import com.techelevator.strategies.nurturable.NuturableStrategy;

public class SellBySetPriceStrategy extends SellableStrategy {

    protected SellBySetPriceStrategy(double sellingPrice) {
        super(sellingPrice);
    }
    @Override
    public double sell(NuturableStrategy.State state) {
        if(state == NuturableStrategy.State.HEALTHY || state == NuturableStrategy.State.AVERAGE) {
            return this.getSellingPrice();
        }
        return 0;
    }
    @Override
    public double getOffer() {
        return this.getSellingPrice();
    }
}
