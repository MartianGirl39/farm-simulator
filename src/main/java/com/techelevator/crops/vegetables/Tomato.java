package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.strategies.nurturable.NuturableStrategy;
import com.techelevator.strategies.harvestable.HarvestableStrategy;

public class Tomato extends Crop {
    public Tomato(NuturableStrategy growth, HarvestableStrategy harvest) {
        super("tomato", growth, harvest);
    }
}
