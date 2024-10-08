package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class Potato extends Crop {

    public Potato(NuturableStrategy growth, HarvestableStrategy harvest) {
        super("potato", growth, harvest);
    }
}
