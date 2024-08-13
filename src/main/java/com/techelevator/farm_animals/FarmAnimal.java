package com.techelevator.farm_animals;

import com.techelevator.products.Product;
import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;
import com.techelevator.strategies.sellable.SellableStrategy;

public abstract class FarmAnimal {
    private final String species;
    private final String name;
    private final NuturableStrategy growth;
    final SellableStrategy sell;

    protected FarmAnimal(String species, String name, NuturableStrategy growth, SellableStrategy sell) {
        this.species = species;
        this.name = name;
        this.growth = growth;
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String feed(int food){
        this.growth.feed(food);
        return this.growth.getState().toString() == "Withered" ? "Sickly" : this.growth.getState().toString();
    }

    public NuturableStrategy.State getHealth(){
        return this.growth.getState();
    }

    public String accountForWaterGiven(int waterGivenToday){
        this.growth.giveWater(waterGivenToday);
        return this.growth.getState().toString() == "Withered" ? "Sickly" : this.growth.getState().toString();
    }

    public double sell(){
        return sell.sell(this.getHealth());
    }

    public double getSellPrice(){
        return sell.getOffer();
    }
}
