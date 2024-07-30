package com.techelevator.farm_animals.animals;

import com.techelevator.farm_animals.SlaughterableAnimal;
import com.techelevator.products.Product;
import com.techelevator.strategies.growable.MinMaxGrowableStrategy;
import com.techelevator.strategies.harvestable.GreenHouseHarvestableStrategy;

public class Chicken extends SlaughterableAnimal {
    public Chicken(String name) {
        super("chicken", name, new MinMaxGrowableStrategy(1, 10,1, Integer.MAX_VALUE), new GreenHouseHarvestableStrategy(1, new Product("eggs", .50), 1), new Product("chicken meat", 80));
    }
}
