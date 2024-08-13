package com.techelevator.farm_animals.animals;

import com.techelevator.farm_animals.FarmAnimal;
import com.techelevator.products.Product;
import com.techelevator.strategies.harvestable.SingleHarvestStrategy;
import com.techelevator.strategies.nurturable.MinMaxNurtureStrategy;
import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.sellable.SellableStrategy;

class Pig extends FarmAnimal {
    public Pig(String species, String name, NuturableStrategy growth, SellableStrategy sell) {
        super(species, name, growth, sell);
    }
}
