package com.techelevator.strategies.harvestable;

import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.products.Product;

import java.time.Month;

public abstract class HarvestableStrategy {

    private int yield;
    private Product product;
    private int harvested;

    public HarvestableStrategy(int yield, Product product){
        this.yield = yield;
        this.product = product;
        this.harvested = 0;
    }

    public abstract Product[] harvest(NuturableStrategy.State state);

    public abstract Product[] harvest(NuturableStrategy.State state, Month month);

    public int getYield() {
        return yield;
    }

    public int getHarvested() {
        return harvested;
    }

    public Product getProduct() {
        return product;
    }

    protected Product[] getProducts() {
        Product[] products = new Product[this.yield];
        for(int i=0; i<products.length; i++){
            products[i] = product;
        }
        this.harvested++;
        return products;
    }

    public abstract String getHarvestConditions();
}
