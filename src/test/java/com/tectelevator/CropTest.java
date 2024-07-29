package com.tectelevator;

import com.techelevator.crops.Crop;
import com.techelevator.crops.MultiHarvestCrop;
import com.techelevator.crops.SingleHarvestCrop;
import com.techelevator.crops.vegetables.Carrot;
import com.techelevator.crops.vegetables.Tomato;
import org.junit.Test;

import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CropTest {

    @Test
    public void testInit(){
         Crop crop = new Carrot();
         assertNotNull(crop);
         assertEquals("carrot", crop.getName());
         assertEquals(Month.JUNE, crop.getSeasonStart());
    }

    @Test
    public void testCarrot(){
        Crop crop = new Carrot();
        assertEquals("carrot", crop.getName());
    }

    @Test
    public void testSingleHarvest(){
        Crop crop = new Carrot();
        assertEquals(1, crop.harvest(Month.JULY).length);
        assertEquals(0, crop.harvest(Month.JULY).length);

        Crop crop2 = new Carrot();
        assertEquals(1, crop2.harvest(Month.AUGUST).length);
        assertEquals(0, crop2.harvest(Month.AUGUST).length);

        Crop crop3 = new Carrot();
        assertEquals(crop3.getClass(), crop3.harvest(Month.JULY)[0].getClass());

        Crop crop4 = new Carrot();
        crop4.water(2000);
        assertEquals("DEAD", crop4.getState());
        assertEquals(0, crop4.harvest(Month.JULY).length);

    }

    @Test public void testMultiHarvest(){
        Crop crop = new Tomato(Month.JANUARY);
        assertEquals(crop.getHarvestYield(), crop.harvest(Month.JULY).length);
        assertEquals(0, crop.harvest(Month.AUGUST).length);
        assertEquals(crop.getHarvestYield(), crop.harvest(Month.SEPTEMBER).length);
        assertEquals(0, crop.harvest(Month.DECEMBER).length);
        crop.harvest(Month.JULY);
        crop.harvest(Month.JULY);
        assertEquals(0, crop.harvest(Month.AUGUST).length);

        Crop crop1 = new Tomato(Month.JANUARY);
        crop1.water(2000);
        assertEquals("DEAD", crop1.getState());
        assertEquals(0, crop1.harvest(Month.AUGUST).length);
    }

}
