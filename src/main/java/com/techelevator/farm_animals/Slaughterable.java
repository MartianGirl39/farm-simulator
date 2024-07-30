package com.techelevator.farm_animals;

import com.techelevator.products.Product;

public interface Slaughterable {
    public Product slaughter();

    public boolean isSlaughtered();
}
