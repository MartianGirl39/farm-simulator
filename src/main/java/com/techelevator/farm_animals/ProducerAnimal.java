package com.techelevator.farm_animals;

import com.techelevator.exceptions.AnimalSoldException;
import com.techelevator.products.Product;
import com.techelevator.strategies.harvestable.HarvestableStrategy;
import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.sellable.SellableStrategy;

public abstract class ProducerAnimal extends FarmAnimal {
    private final HarvestableStrategy harvest;


    protected ProducerAnimal(String species, String name, NuturableStrategy growth, HarvestableStrategy harvest, SellableStrategy sell) {
        super(species, name, growth, sell);
        this.harvest = harvest;
    }

    public Product[] harvestProduct(){
        if(super.sell.isSold()) {
            return this.harvest.harvest(super.getHealth());
        }
        throw new AnimalSoldException("Animal was already sold");
    }
}
