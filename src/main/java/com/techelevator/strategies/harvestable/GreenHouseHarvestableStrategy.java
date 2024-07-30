package com.techelevator.strategies.harvestable;

import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.products.Product;

import java.time.LocalDate;

public class GreenHouseHarvestableStrategy extends HarvestableStrategy {
    private LocalDate lastHarvest;
    private int intervalUntilNextHarvest;

    public GreenHouseHarvestableStrategy(int yield, Product product, int intervalUntilNextHarvest) {
        super(yield, product);
        this.intervalUntilNextHarvest = intervalUntilNextHarvest;
        this.lastHarvest = LocalDate.now();
    }

    @Override
    public Product[] harvest(GrowableStrategy.State state) {
        if((state == GrowableStrategy.State.HEALTHY || state == GrowableStrategy.State.AVERAGE)){
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
    public String getHarvestConditions() {
        return "";
    }
}
