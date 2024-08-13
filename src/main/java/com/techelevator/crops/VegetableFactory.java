package com.techelevator.crops;

import com.techelevator.crops.vegetables.Broccoli;
import com.techelevator.crops.vegetables.Carrot;
import com.techelevator.crops.vegetables.Potato;
import com.techelevator.crops.vegetables.Tomato;
import com.techelevator.strategies.harvestable.HarvestableStrategy;
import com.techelevator.strategies.nurturable.NuturableStrategy;

public class VegetableFactory {
    NuturableStrategy growth;
    HarvestableStrategy harvest;
    
    public VegetableFactory(){}
    
    public VegetableFactory(NuturableStrategy growth, HarvestableStrategy harvest){
        this.growth = growth;
        this.harvest = harvest;
    }

    public void setGrowth(NuturableStrategy growth) {
        this.growth = growth;
    }

    public void setHarvest(HarvestableStrategy harvest) {
        this.harvest = harvest;
    }
    
    public Carrot getCarrot(){
        return new Carrot(growth, harvest);
    }
    
    public Potato getNewPotato(){
        return new Potato(growth, harvest);
    }
    
    public Tomato getNewTomato(){
        return new Tomato(growth, harvest);
    }
    
    public Broccoli getNewBroccoli(){
        return new Broccoli(growth, harvest);
    }
}
