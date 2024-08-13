package com.techelevator.crops;

import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;
import com.techelevator.products.Product;

public abstract class Crop {
    private final String name;    //  every crop has a name, right
    private final NuturableStrategy growth;
    private final HarvestableStrategy harvest;

        protected Crop(String name, NuturableStrategy growth, HarvestableStrategy harvest){
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
            return this.growth.getHealthRequirements();
    }

    public String getHarvestRequirements() {
            return this.harvest.getHarvestConditions();
    }

    public String toString() {
        return String.format("%s, status: %s", this.getName(), this.growth.getState());
    }

    public String water(int inchesOfWater){
            return growth.giveWater(inchesOfWater).toString();
    }

    public String accountForSunlight(int hoursOfSunlight){
            return growth.feed(hoursOfSunlight).toString();
    }

    public Product[] harvest() {
        return harvest.harvest(growth.getState());
    }
}
