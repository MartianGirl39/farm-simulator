package com.techelevator.crops;

import com.techelevator.crops.strategies.GrowableStrategy;

import java.time.LocalDate;
import java.time.Month;

public class MultiHarvestCrop extends Crop implements YieldsHarvest {
    int harvestsPerSeason;
    int intervalBetweenHarvest;
    int harvested;
    Month lastHarvest;

    public MultiHarvestCrop(int harvestsPerSeason, int intervalBetweenHarvest, Crop.Builder builder){
        super(builder);
        this.harvestsPerSeason = harvestsPerSeason;
        this.intervalBetweenHarvest = intervalBetweenHarvest;
        this.lastHarvest = LocalDate.now().getMonth();
    }

    public MultiHarvestCrop(int harvestsPerSeason, int intervalBetweenHarvest, Month monthPlanted, Crop.Builder builder){
        super(builder);
        this.harvestsPerSeason = harvestsPerSeason;
        this.intervalBetweenHarvest = intervalBetweenHarvest;
        this.lastHarvest = monthPlanted;
    }

    public int getHarvestsPerSeason() {
        return harvestsPerSeason;
    }

    public int getIntervalBetweenHarvest() {
        return intervalBetweenHarvest;
    }

    public int getTimesHarvested() {
        return harvested;
    }

    public int getHarvestsLeft(){
        return harvestsPerSeason - harvested;
    }

    @Override
    public Crop[] harvest() {
        if(this.harvested <= harvestsPerSeason && super.getIsInSeason(LocalDate.now().getMonth()) && (LocalDate.now().getMonth().getValue() >= lastHarvest.getValue() + this.intervalBetweenHarvest) && this.growth.getState() != GrowableStrategy.State.DEAD){
            this.harvested++;
            this.lastHarvest = LocalDate.now().getMonth();
            Crop[] crops = new Crop[super.getHarvestYield()];
            for(int i=0; i<crops.length; i++){
                crops[i] = this;
            }
            return crops;
        }
        return new Crop[0];
    }

    @Override
    public Crop[] harvest(Month month) {
        if(this.harvested <= harvestsPerSeason && super.getIsInSeason(month) && (month.getValue() >= lastHarvest.getValue() + this.intervalBetweenHarvest && this.growth.getState() != GrowableStrategy.State.DEAD)){
            this.harvested++;
            this.lastHarvest = month;
            Crop[] crops = new Crop[super.getHarvestYield()];
            for(int i=0; i<crops.length; i++){
                crops[i] = this;
            }
            return crops;
        }
        return new Crop[0];
    }
}
