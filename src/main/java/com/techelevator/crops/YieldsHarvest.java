package com.techelevator.crops;

import java.time.Month;

public interface YieldsHarvest {
    public Crop[] harvest();
    public Crop[] harvest(Month month);
}
