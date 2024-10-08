package com.techelevator.products;

public class Product {
    private final String name;
    private final double currentValue;

    public Product(String name, double currentValue){
        this.name = name;
        this.currentValue = currentValue;
    }

    public Product makeCopy(){
        return this;
    }

    public Product makeDeprecatedCopy(double toDeprecate){
        return new Product(this.name, this.currentValue - toDeprecate);
    }

    public String getName() {
        return name;
    }

    public double getCurrentValue() {
        return currentValue;
    }

}
