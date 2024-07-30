package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class Carrot extends Crop {
    public Carrot(GrowableStrategy growth, HarvestableStrategy harvest) {
        super("carrot", growth, harvest);
    }
}
