package com.techelevator.farm_animals.animals;

import com.techelevator.farm_animals.SlaughterableAnimal;
import com.techelevator.products.Product;
import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.strategies.growable.MinMaxGrowableStrategy;
import com.techelevator.strategies.harvestable.GreenHouseHarvestableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class Cow extends SlaughterableAnimal {
    public Cow(String name) {
        super("cow", name, new MinMaxGrowableStrategy(1, 10,1, Integer.MAX_VALUE), new GreenHouseHarvestableStrategy(1, new Product("milk", 1.50), 1), new Product("steak", 600));
    }
}
