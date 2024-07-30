package com.techelevator.strategies.harvestable;

import com.techelevator.strategies.growable.GrowableStrategy;
import com.techelevator.products.Product;

import java.time.LocalDate;
import java.time.Month;

public class SeasonalHarvestableStrategy extends HarvestableStrategy {
    private Month seasonStart, seasonEnd;
    private Month lastHarvest;

    public SeasonalHarvestableStrategy(int yield, Product product, Month seasonStart, Month seasonEnd) {
        super(yield, product);
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
    }

    @Override
    public Product[] harvest(GrowableStrategy.State state) {
        if(!this.getIsInSeason(LocalDate.now().getMonth()) || state == GrowableStrategy.State.DEAD){
            return null;
        }
        return super.getProducts();
    }

    @Override
    public String getHarvestConditions() {
        return String.format("Plant must be harvest in season\nStart of season: %s\nEnd of season: %s", this.seasonStart, this.seasonEnd);
    }

    public Product[] harvest(GrowableStrategy.State state, Month month) {
        if(!this.getIsInSeason(month) || state == GrowableStrategy.State.DEAD){
            return null;
        }
        return super.getProducts();
    }

    public Month getSeasonStart() {
        return seasonStart;
    }

    public Month getSeasonEnd() {
        return seasonEnd;
    }

    public boolean getIsInSeason(Month month){
        if(seasonStart.getValue() > seasonEnd.getValue()){
            return month.getValue() >= seasonStart.getValue() || month.getValue() <= seasonEnd.getValue();
        }
        return month.getValue() >= seasonStart.getValue() && month.getValue() <= seasonEnd.getValue();
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
}
