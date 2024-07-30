package com.techelevator.farm_animals;

import com.techelevator.farm_animals.FarmAnimal;
import com.techelevator.farm_animals.Slaughterable;
import com.techelevator.products.Product;
import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class SlaughterableAnimal extends FarmAnimal implements Slaughterable{

    private final Product slaughterProduct;
    private boolean isSlaughtered = false;

    public SlaughterableAnimal(String species, String name, GrowableStrategy growth, HarvestableStrategy harvest, Product slaughterProduct){
        super(species, name, growth, harvest);
        this.slaughterProduct = slaughterProduct;
    }

    @Override
    public Product[] harvestProduct() {
        if(isSlaughtered){
            throw new RuntimeException();
        }
        return super.harvestProduct();
    }

    @Override
    public String feed(int food) {
        if(isSlaughtered){
            throw new RuntimeException();
        }
        return super.feed(food);
    }

    @Override
    public String accountForWaterGiven(int waterGivenToday) {
        if(isSlaughtered){
            throw new RuntimeException();
        }
        return super.accountForWaterGiven(waterGivenToday);
    }

    @Override
    public Product slaughter() {
        if(!isSlaughtered){
            this.isSlaughtered = true;
            return slaughterProduct;
        }
        throw new RuntimeException();
    }

    @Override
    public boolean isSlaughtered() {
        return this.isSlaughtered;
    }
}
