package com.techelevator.farm_animals;

import com.techelevator.farm.Farm;
import com.techelevator.products.Product;
import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.strategies.growable.MinMaxGrowableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class FarmAnimal {
    private final String species;
    private final String name;
    private final GrowableStrategy growth;
    private final HarvestableStrategy harvest;

    protected FarmAnimal(String species, String name, GrowableStrategy growth, HarvestableStrategy harvest){
        this.species = species;
        this.name = name;
        this.growth = growth;
        this.harvest = harvest;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String feed(int food){
        this.growth.water(food);
        return this.growth.getState().toString() == "Withered" ? "Sickly" : this.growth.getState().toString();
    }

    public String getHealth(){
        return this.growth.getState().toString() == "Withered" ? "Sickly" : this.growth.getState().toString();
    }

    public String accountForWaterGiven(int waterGivenToday){
        this.growth.accountForSunlight(waterGivenToday);
        return this.growth.getState().toString() == "Withered" ? "Sickly" : this.growth.getState().toString();
    }

    public Product[] harvestProduct(){
        return this.harvest.harvest(growth.getState());
    }
}
