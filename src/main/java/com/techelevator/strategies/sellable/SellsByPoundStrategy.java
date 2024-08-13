package com.techelevator.strategies.sellable;

import com.techelevator.strategies.nurturable.NuturableStrategy;

public class SellsByPoundStrategy extends SellableStrategy {
    int weight;
    SellsByPoundStrategy(double sellingPrice){
        super(sellingPrice);
    }

    @Override
    public double sell(NuturableStrategy.State state) throws RuntimeException {
        if(isSold){
            throw new RuntimeException(); // already sold exception
        }
        if(state == NuturableStrategy.State.HEALTHY || state == NuturableStrategy.State.AVERAGE) {
            this.isSold = true;
            return super.getSellingPrice() * weight;
        }
        return 0;
    }

    @Override
    public double getOffer() {
        return super.getSellingPrice() * weight;

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
