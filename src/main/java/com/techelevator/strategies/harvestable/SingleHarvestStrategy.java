package com.techelevator.strategies.harvestable;

import com.techelevator.products.Product;
import com.techelevator.strategies.nurturable.NuturableStrategy;

import java.time.Month;

public class SingleHarvestStrategy extends HarvestableStrategy {
    boolean isHarvested;

    public SingleHarvestStrategy(int yield, Product product) {
        super(yield, product);
        this.isHarvested = false;
    }


    @Override
    public Product[] harvest(NuturableStrategy.State state) throws RuntimeException {
        if(isHarvested){
            throw new RuntimeException();
        }
        return super.getProducts();
    }

    @Override
    public Product[] harvest(NuturableStrategy.State state, Month month) {
        if(state == NuturableStrategy.State.DEAD || isHarvested){
            return null;
        }
        return super.getProducts();
    }

    @Override
    public String getHarvestConditions() {
        return "Can only harvest once. Have you harvested: " + isHarvested;
    }
}
