package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.crops.MultiHarvestCrop;
import com.techelevator.crops.strategies.MinMaxGrowableStrategy;

import java.time.LocalDate;
import java.time.Month;

public class Potato extends MultiHarvestCrop {
    public Potato(){
        //  build a carrot with single harvest crop
        super(3, 2, new Crop.Builder()
                .setName("potato")
                .setSeason(Month.JUNE, Month.OCTOBER)
                .setGrowthStrategy(new MinMaxGrowableStrategy(1, 3, 6, 9))
                .setPlantFamily("")
                .setLevel(Crop.Level.HIGH)
                .setHarvestYield(((int)(Math.random() * (6 - 3 + 1)+3)))
                .setMonthPlanted(LocalDate.now().getMonth())
                .setRootSystem(RootDepth.SHALLOW));
    }

    public Potato(Month monthPlanted){
        //  build a carrot with single harvest crop
        super(3, 2, new Crop.Builder()
                .setName("potato")
                .setSeason(Month.JUNE, Month.OCTOBER)
                .setGrowthStrategy(new MinMaxGrowableStrategy(1, 3, 6, 9))
                .setPlantFamily("")
                .setLevel(Crop.Level.HIGH)
                .setHarvestYield(((int)(Math.random() * (6 - 3 + 1)+3)))
                .setMonthPlanted(monthPlanted)
                .setRootSystem(RootDepth.SHALLOW));
    }
}
