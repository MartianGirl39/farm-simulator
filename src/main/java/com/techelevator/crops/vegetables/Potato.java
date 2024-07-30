package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class Potato extends Crop {

    public Potato(GrowableStrategy growth, HarvestableStrategy harvest) {
        super("potato", growth, harvest);
    }
}
