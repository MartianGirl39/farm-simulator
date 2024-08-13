package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class Carrot extends Crop {
    public Carrot(NuturableStrategy growth, HarvestableStrategy harvest) {
        super("carrot", growth, harvest);
    }
}
