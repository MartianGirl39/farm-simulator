package com.techelevator.farm_animals.animals;

import com.techelevator.farm_animals.SlaughterableAnimal;
import com.techelevator.products.Product;
import com.techelevator.strategies.growable.MinMaxGrowableStrategy;

public class Pig extends SlaughterableAnimal {

    public Pig(String name) {
        super("pig", name, new MinMaxGrowableStrategy(1, 10,1, Integer.MAX_VALUE), null, new Product("pork", 500));
    }

    @Override
    public Product[] harvestProduct(){
        return new Product[0];
    }
}
