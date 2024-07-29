package com.techelevator.crops.vegetables;

import com.techelevator.crops.Crop;
import com.techelevator.crops.MultiHarvestCrop;
import com.techelevator.crops.strategies.MinMaxGrowableStrategy;

import java.time.LocalDate;
import java.time.Month;

public class Tomato extends MultiHarvestCrop {
    public Tomato(){
        //  build a carrot with single harvest crop
        super(4, 2, new Crop.Builder()
                .setName("potato")
                .setSeason(Month.MAY, Month.OCTOBER)
                .setGrowthStrategy(new MinMaxGrowableStrategy(1, 3, 6, 10))
                .setPlantFamily("nightshade")
                .setLevel(Crop.Level.HIGH)
                .setHarvestYield(((int)(Math.random() * (20 - 10 + 1)+10)))
                .setMonthPlanted(LocalDate.now().getMonth())
                .setRootSystem(RootDepth.MODERATE));
    }

    public Tomato(Month monthPlanted){
        //  build a carrot with single harvest crop
        super(4, 2, monthPlanted, new Crop.Builder()
                .setName("potato")
                .setSeason(Month.MAY, Month.OCTOBER)
                .setGrowthStrategy(new MinMaxGrowableStrategy(1, 3, 6, 10))
                .setPlantFamily("nightshade")
                .setLevel(Crop.Level.HIGH)
                .setHarvestYield(((int)(Math.random() * (20 - 10 + 1)+10)))
                .setMonthPlanted(monthPlanted)
                .setRootSystem(RootDepth.MODERATE));
    }
}
