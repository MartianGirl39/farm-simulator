package com.techelevator.strategies.growable;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MinMaxGrowableStrategy extends GrowableStrategy {

    // for updates
    private final DayOfWeek startOfWeek;
    private LocalDate lastUpdate;

    // to keep up with gardeners practices for the week
    private double inchesOfWaterThisWeek = 0;
    private double hoursOfSunlightToday;
    private int daysWaterOverUnderMax = 0;
    private int daysSunOverUnderMax = 0;

    // min and max for water and sunlight
    double minWaterPerWeek;
    double maxWaterPerWeek;
    double minSunlightPerWeek;
    double maxSunlightPerWeek;

    public MinMaxGrowableStrategy(int minWater, int maxWater, int minSunlight, int maxSunlight){
        super();
        this.startOfWeek = LocalDate.now().getDayOfWeek();
        this.minWaterPerWeek = maxWater;
        this.maxWaterPerWeek = maxWater;
        this.minSunlightPerWeek = minSunlight;
        this.maxSunlightPerWeek = maxSunlight;
        this.lastUpdate = LocalDate.now();
    }

    protected void checkForRestart(){
        if(lastUpdate.getDayOfYear() != LocalDate.now().getDayOfYear()){
            this.hoursOfSunlightToday = 0;
        }
        if(LocalDate.now().getDayOfWeek() == startOfWeek && lastUpdate.getDayOfYear() != LocalDate.now().getDayOfYear()){
            this.inchesOfWaterThisWeek = 0;
            this.daysSunOverUnderMax = this.daysWaterOverUnderMax/2;
            this.daysWaterOverUnderMax = this.daysSunOverUnderMax/2;
        }
        lastUpdate = LocalDate.now();
    }

    public State checkForState(int check){
        if(super.getState() != State.DEAD){
            switch (check) {
                case 0:
                    this.setState(State.HEALTHY);
                    break;
                case 1:
                    this.setState(State.AVERAGE);
                    break;
                case 2:
                    this.setState(State.UNHEALTHY);
                    break;
                case 3:
                    this.setState(State.WITHERED);
                    break;
                default:
                    this.setState(State.DEAD);
                    break;
            }
        }
        return this.getState();
    }

    @Override
    public State water(int inchesOfWater) {
        checkForRestart();
        this.inchesOfWaterThisWeek += inchesOfWater;
        this.daysWaterOverUnderMax = this.inchesOfWaterThisWeek < this.minWaterPerWeek || this.daysWaterOverUnderMax > this.maxWaterPerWeek ? this.daysWaterOverUnderMax + 1 : this.daysWaterOverUnderMax;
        if(inchesOfWaterThisWeek > this.maxWaterPerWeek + 10){
            this.setState(State.DEAD);
            return State.DEAD;
        }
        return this.checkForState(this.daysWaterOverUnderMax);
    }

    @Override
    public State accountForSunlight(int hoursOfSunlight) {
        checkForRestart();
        this.hoursOfSunlightToday += hoursOfSunlight;
        this.daysSunOverUnderMax = this.hoursOfSunlightToday < this.minSunlightPerWeek || this.hoursOfSunlightToday > this.maxWaterPerWeek ? this.daysSunOverUnderMax + 1 : this.daysSunOverUnderMax;
        if(hoursOfSunlight > this.maxSunlightPerWeek + 10){
            this.setState(State.DEAD);
            return State.DEAD;
        }
        return this.checkForState(this.daysSunOverUnderMax);
    }

    @Override
    public String getGrowthRequirements() {
        return String.format("minimum water needed per week: %s\nmaximum water needed per week: %s\nminimum sun needed per day: %s\nmaximum sun needed per day: %s", this.minWaterPerWeek, this.maxWaterPerWeek, this.minSunlightPerWeek, this.maxSunlightPerWeek);
    }
}
