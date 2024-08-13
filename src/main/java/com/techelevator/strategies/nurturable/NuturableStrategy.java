package com.techelevator.strategies.nurturable;

public abstract class NuturableStrategy {
    private State state = State.HEALTHY;

    public static enum State {
        HEALTHY,
        AVERAGE,
        UNHEALTHY,
        WITHERED,
        DEAD
    }
    public NuturableStrategy(){
        this.state = State.HEALTHY;
    }
    public abstract State giveWater(int inchesOfWater);
    public abstract State feed(int hoursOfSunlight);

    public abstract String getHealthRequirements();

    public State getState() {
        return state;
    }

    protected void setState(State state) {
        this.state = state;
    }
}
