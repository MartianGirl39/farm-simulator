package com.techelevator.crops;

import com.techelevator.crops.strategies.GrowableStrategy;

import java.time.LocalDate;
import java.time.Month;

public class SingleHarvestCrop extends Crop implements YieldsHarvest{
    private boolean harvested;

    public SingleHarvestCrop(Crop.Builder builder){
        super(builder);
        this.harvested = false;
    }

    public boolean isHarvested() {
        return harvested;
    }

    @Override
    public Crop[] harvest() {
        if((harvested && super.getIsInSeason(LocalDate.now().getMonth())) || this.growth.getState() == GrowableStrategy.State.DEAD){
            return new Crop[0];
        }
        harvested = true;
        Crop[] crops = new Crop[1];
        crops[0] = this;
        return crops;
    }

    @Override
    public Crop[] harvest(Month month) {
        if((harvested && super.getIsInSeason(month)) || this.growth.getState() == GrowableStrategy.State.DEAD){
            return new Crop[0];
        }
        harvested = true;
        Crop[] crops = new Crop[1];
        crops[0] = this;
        return crops;
    }
}
