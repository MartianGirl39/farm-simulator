package com.tectelevator;

import com.techelevator.crops.Crop;
import com.techelevator.crops.vegetables.Carrot;
import com.techelevator.crops.vegetables.Tomato;
import com.techelevator.products.Product;
import com.techelevator.strategies.growable.MinMaxGrowableStrategy;
import com.techelevator.strategies.harvestable.GreenHouseHarvestableStrategy;
import org.junit.Test;

import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CropTest {
    @Test
    public void TestCropConstructor(){
        assertNotNull(new Carrot(new MinMaxGrowableStrategy(1, 2,3, 4), new GreenHouseHarvestableStrategy(2, new Product("carrot", 1.12), 5)));
    }
}
