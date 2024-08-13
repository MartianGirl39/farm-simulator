package com.tectelevator;

import com.techelevator.crops.vegetables.Carrot;
import com.techelevator.products.Product;
import com.techelevator.strategies.nurturable.MinMaxNurtureStrategy;
import com.techelevator.strategies.harvestable.IntervalHarvesStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CropTest {
    @Test
    public void TestCropConstructor(){
        assertNotNull(new Carrot(new MinMaxNurtureStrategy(1, 2,3, 4), new IntervalHarvesStrategy(2, new Product("carrot", 1.12), 5)));
    }
}
