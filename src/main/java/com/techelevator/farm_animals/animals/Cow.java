package com.techelevator.farm_animals.animals;

import com.techelevator.farm_animals.ProducerAnimal;
import com.techelevator.strategies.harvestable.HarvestableStrategy;
import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.sellable.SellableStrategy;

public class Cow extends ProducerAnimal {

    protected Cow(String species, String name, NuturableStrategy growth, HarvestableStrategy harvest, SellableStrategy sell) {
        super(species, name, growth, harvest, sell);
    }
}
