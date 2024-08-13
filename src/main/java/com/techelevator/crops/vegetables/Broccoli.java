package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.strategies.harvestable.HarvestableStrategy;
import com.techelevator.strategies.nurturable.NuturableStrategy;

public class Broccoli extends Crop {

    public Broccoli(NuturableStrategy growth, HarvestableStrategy harvest) {
        super("broccoli", growth, harvest);
    }
}
