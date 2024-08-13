package com.techelevator.strategies.harvestable;

import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.products.Product;

import java.time.LocalDate;
import java.time.Month;

public class MultiHarvestSeasonalHarvestStrategy extends SeasonalHarvestStrategy {
    int harvestsPerSeason;
    int intervalBetweenHarvest;
    LocalDate lastHarvest;
    public MultiHarvestSeasonalHarvestStrategy(int yield, Product product, Month seasonStart, Month seasonEnd, int harvestsPerSeason, int intervalBetweenHarvest) {
        super(yield, product, seasonStart, seasonEnd);
        this.harvestsPerSeason = harvestsPerSeason;
        this.intervalBetweenHarvest = intervalBetweenHarvest;
        this.lastHarvest = LocalDate.now();
    }

    @Override
    public Product[] harvest(NuturableStrategy.State state) {
        if(!this.getIsInSeason(LocalDate.now().getMonth()) || state == NuturableStrategy.State.DEAD){
            return null;
        }
        boolean greater = this.lastHarvest.getDayOfYear() < LocalDate.now().getDayOfYear();
        if(greater && LocalDate.now().getDayOfYear() - this.lastHarvest.getDayOfYear() >= this.intervalBetweenHarvest){
            this.lastHarvest = LocalDate.now();
            return getProducts();
        }
        else if(!greater && (365 - this.lastHarvest.getDayOfYear()) + LocalDate.now().getDayOfYear() >= this.intervalBetweenHarvest){
            this.lastHarvest = LocalDate.now();
            return super.getProducts();
        }
        return null;
    }

    public Product[] harvest(NuturableStrategy.State state, Month month) {
        if(!this.getIsInSeason(LocalDate.now().getMonth()) || state == NuturableStrategy.State.DEAD){
            return null;
        }
        boolean greater = this.lastHarvest.getDayOfYear() < LocalDate.now().getDayOfYear();
        if(greater && LocalDate.now().getDayOfYear() - this.lastHarvest.getDayOfYear() >= this.intervalBetweenHarvest){
            this.lastHarvest = LocalDate.now();
            return getProducts();
        }
        else if(!greater && (365 - this.lastHarvest.getDayOfYear()) + LocalDate.now().getDayOfYear() >= this.intervalBetweenHarvest){
            this.lastHarvest = LocalDate.now();
            return super.getProducts();
        }
        return null;
    }

}
