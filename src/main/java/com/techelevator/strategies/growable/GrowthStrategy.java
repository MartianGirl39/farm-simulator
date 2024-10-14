package com.techelevator.strategies.growable;

import com.techelevator.strategies.nurturable.NuturableStrategy;

public abstract class GrowthStrategy {

    enum Stage {

    }
    abstract void checkForGrowth(NuturableStrategy.State state);
    abstract Stage getGrowthStage();
}
