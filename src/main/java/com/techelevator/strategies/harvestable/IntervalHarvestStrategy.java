package com.techelevator.strategies.harvestable;

import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.products.Product;

import java.time.LocalDate;
import java.time.Month;

public class IntervalHarvestStrategy extends HarvestableStrategy {
    private LocalDate lastHarvest;
    private int intervalUntilNextHarvest;

    public IntervalHarvestStrategy(int yield, Product product, int intervalUntilNextHarvest) {
        super(yield, product);
        this.intervalUntilNextHarvest = intervalUntilNextHarvest;
        this.lastHarvest = LocalDate.now();
    }

    @Override
    public Product[] harvest(NuturableStrategy.State state) {
        if((state == NuturableStrategy.State.HEALTHY || state == NuturableStrategy.State.AVERAGE)){
            boolean greater = this.lastHarvest.getDayOfYear() < LocalDate.now().getDayOfYear();
            if(greater && LocalDate.now().getDayOfYear() - this.lastHarvest.getDayOfYear() >= this.intervalUntilNextHarvest){
                this.lastHarvest = LocalDate.now();
                return getProducts();
            }
            else if(!greater && (365 - this.lastHarvest.getDayOfYear()) + LocalDate.now().getDayOfYear() >= this.intervalUntilNextHarvest){
                this.lastHarvest = LocalDate.now();
                return super.getProducts();
            }
            return null;
        }
        return null;
    }

    @Override
    public Product[] harvest(NuturableStrategy.State state, Month month) {
        return new Product[0];
    }

    @Override
    public String getHarvestConditions() {
        return "";
    }
}
