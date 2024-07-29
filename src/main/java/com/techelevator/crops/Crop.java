package com.techelevator.crops;

import com.techelevator.crops.strategies.GrowableStrategy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crop {
    private String name;    //  every crop has a name, right
    private Month seasonStart; //  most crops have a season in which they grow best
    private Month seasonEnd;   //  most crops have a season in which they grow best
    private String plantFamily;   //  denotes a type, such as nightshade or brasscias
    private RootDepth rootSystem;  //  this may affect how often and how much it needs to be watered
    private Level feederLevel; //  this may Affect how plants interact
    private int harvestYield;   //  all plants have a harvest yield this will be determined by plant
    private Month monthPlanted;

    GrowableStrategy growth;

//    private double minWaterPerWeek; //  most plants can be drowned and will die if drowned
//    private double maxWaterPerWeek; //  all plants will die without water to my knowledge
//    private double minHoursOfSunlightPerDay;   //  most plants need 6 hours of sunlight per day
//    private double maxHoursOfSunlightPerDay;   //  too much sunlight can dehydrate a plant

    //  for managing user encounters with crop that should be the same with all crops

    //public static final List<String >months  = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

        protected Crop(Builder crop){
            //System.out.println("Began constructing");
            this.name = crop.name;
            this.seasonStart = crop.seasonStart;
            this.seasonEnd = crop.seasonEnd;
            this.plantFamily = crop.plantFamily;
            this.rootSystem = crop.rootSystem;
            this.feederLevel = crop.feederLevel;
            this.harvestYield = crop.harvestYield;
            this.monthPlanted = crop.monthPlanted;
            this.growth = crop.growthStrategy;
        }

    public Crop[] harvest() {
            return null;
    }

    public Crop[] harvest(Month month) {
        return null;
    }

    public static enum Level {
        HIGH,
        MODERATE,
        LOW
    }

    public static enum RootDepth {
            DEEP,
            MODERATE,
            SHALLOW
    }

    public String getName() {
        return name;
    }

    public Month getSeasonStart() {
        return seasonStart;
    }

    public Month getSeasonEnd() {
        return seasonEnd;
    }

    public String getPlantFamily() {
        return plantFamily;
    }

    public RootDepth getRootSystem() {
        return rootSystem;
    }

    public Level getFeederLevel() {
        return feederLevel;
    }

    public int getHarvestYield() {
        return harvestYield;
    }

    public int getNumOfMonthsInSeason() {
        return seasonEnd.getValue() - (seasonStart.getValue() - 1);
    }

    public int getNumOfMonthsLeftInSeason(Month currentMonth) {
        // check if currentMonth is between seasonStart and seasonEnd
        Month month = currentMonth;
        int count = 0;
        while (!month.equals(seasonEnd.plus(1))) {
            count++;
            month = month.plus(1);
        }
        return count;
    }

    public int getNumOfDaysInSeason() {
        Month month = seasonStart;
        int sum = 0;
        while (!month.equals(seasonEnd.plus(1))) {
            sum += month.length(true);
            month = month.plus(1);
        }
        return sum;
    }

    public int getNumOfDaysLeftInSeason(LocalDate date) {
        int sum = 0;
        Month month = date.getMonth();
        int daysDiff = month.length(true) - date.getDayOfMonth();
        month = month.plus(1);
        for (int i = month.getValue(); i <= seasonEnd.getValue(); i++) {
            month = month.plus(1);
            sum += month.length(true);
        }
        return sum + daysDiff;
    }

    public String getState() {
        return this.growth.getState().toString();
    }

    public boolean getIsInSeason(Month month){
            if(seasonStart.getValue() > seasonEnd.getValue()){
                return month.getValue() >= seasonStart.getValue() || month.getValue() <= seasonEnd.getValue();
            }
            return month.getValue() >= seasonStart.getValue() && month.getValue() <= seasonEnd.getValue();
    }

    public String getGrowthRequirements(){
            return this.growth.getGrowthRequirements();
    }

    public static class Builder {
        private String name;    //  every crop has a name, right
        private Month seasonStart; //  most crops have a season in which they grow best
        private Month seasonEnd;   //  most crops have a season in which they grow best
        private String plantFamily;   //  denotes a type, such as nightshade or brasscias
        private RootDepth rootSystem;
        private int harvestYield;
        private Level feederLevel;
        //private State state;
        private Month monthPlanted;
        private GrowableStrategy growthStrategy;
//        private double minWaterPerWeek; //  most plants can be drowned and will die if drowned
//        private double maxWaterPerWeek; //  all plants will die without water to my knowledge
//        private int minHoursOfSunlightPerDay;   //  most plants need 6 hours of sunlight per day
//        private int maxHoursOfSunlightPerDay;   //  too much sunlight can dehydrate a plant

        public Builder() {
            //this.state = State.HEALTHY;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSeason(Month seasonStart, Month seasonEnd) {
            this.seasonStart = seasonStart;
            this.seasonEnd = seasonEnd;
            return this;
        }

        public Builder setGrowthStrategy(GrowableStrategy growthStrategy) {
            this.growthStrategy = growthStrategy;
            return this;
        }

        public Builder setPlantFamily(String plantFamily) {
            this.plantFamily = plantFamily;
            return this;
        }

        public Builder setRootSystem(RootDepth rootSystem) {
            this.rootSystem = rootSystem;
            return this;
        }

        public Builder setLevel(Crop.Level feederLevel) {
            this.feederLevel = feederLevel;
            return this;
        }

        public Builder setHarvestYield(int harvestYield) {
            this.harvestYield = harvestYield;
            return this;
        }

        public Builder setMonthPlanted(Month monthPlanted) {
            this.monthPlanted = monthPlanted;
            return this;
        }

        public Crop build() {
            return new Crop(this);
        }
    }

    public String toString() {
        return String.format("%s, status: %s", this.getName(), this.growth.getState());
    }

    public String water(int inchesOfWater){
            return growth.water(inchesOfWater).toString();
    }

    public String accountForSunlight(int hoursOfSunlight){
            return growth.accountForSunlight(hoursOfSunlight).toString();
    }
}
