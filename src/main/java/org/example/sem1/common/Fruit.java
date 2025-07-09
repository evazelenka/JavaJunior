package org.example.sem1.common;

import org.example.sem1.common.interfaces.HealthyFood;

/**
 * Фрукт
 */
public class Fruit implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }
    @Override
    public boolean getFats() {
        return false;
    }
    @Override
    public boolean getCarbohydrates() {
        return true;
    }
    @Override
    public String getName() {
        return "Фрукт";
    }
}
