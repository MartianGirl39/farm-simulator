package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.crops.SingleHarvestCrop;
import com.techelevator.crops.strategies.MinMaxGrowableStrategy;

import java.time.LocalDate;
import java.time.Month;

public class Carrot extends SingleHarvestCrop {
    public Carrot(){
        //  build a carrot with single harvest crop
        super(new Crop.Builder()
                .setName("carrot")
                .setSeason(Month.JUNE, Month.AUGUST)
                .setGrowthStrategy(new MinMaxGrowableStrategy(1, 3, 6, 11))
                .setPlantFamily("")
                .setLevel(Level.LOW)
                .setHarvestYield(1)
                .setMonthPlanted(LocalDate.now().getMonth())
                .setRootSystem(RootDepth.DEEP));
    }

    public Carrot(Month monthPlanted){
        //  build a carrot with single harvest crop
        super(new Crop.Builder()
                .setName("carrot")
                .setSeason(Month.JUNE, Month.AUGUST)
                .setGrowthStrategy(new MinMaxGrowableStrategy(1, 3, 6, 11))
                .setPlantFamily("")
                .setLevel(Level.LOW)
                .setHarvestYield(1)
                .setMonthPlanted(monthPlanted)
                .setRootSystem(RootDepth.DEEP));
    }
}
