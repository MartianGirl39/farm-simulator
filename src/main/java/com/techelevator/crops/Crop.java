package com.techelevator.crops;

import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;
import com.techelevator.products.Product;

public class Crop {
    private final String name;    //  every crop has a name, right
    private final GrowableStrategy growth;
    private final HarvestableStrategy harvest;

        protected Crop(String name, GrowableStrategy growth, HarvestableStrategy harvest){
            this.name = name;
            this.growth = growth;
            this.harvest = harvest;
        }

    public String getName() {
        return name;
    }

    public int getHarvestYield() {
        return harvest.getYield();
    }

    public String getState() {
        return this.growth.getState().toString();
    }

    public String getGrowthRequirements() {
            return this.growth.getGrowthRequirements();
    }

    public String getHarvestRequirements() {
            return this.harvest.getHarvestConditions();
    }

    public String toString() {
        return String.format("%s, status: %s", this.getName(), this.growth.getState());
    }

    public String water(int inchesOfWater){
            return growth.water(inchesOfWater).toString();
    }

    public String accountForSunlight(int hoursOfSunlight){
            return growth.accountForSunlight(hoursOfSunlight).toString();
    }

    public Product[] harvest() {
        return harvest.harvest(growth.getState());
    }
}
