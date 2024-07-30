package com.techelevator.strategies.growable;

import com.techelevator.crops.Crop;

public abstract class GrowableStrategy {
    private State state = State.HEALTHY;

    public static enum State {
        HEALTHY,
        AVERAGE,
        UNHEALTHY,
        WITHERED,
        DEAD
    }
    public GrowableStrategy(){
        this.state = State.HEALTHY;
    }
    public abstract State water(int inchesOfWater);
    public abstract State accountForSunlight(int hoursOfSunlight);

    public abstract String getGrowthRequirements();

    public State getState() {
        return state;
    }

    protected void setState(State state) {
        this.state = state;
    }
}
