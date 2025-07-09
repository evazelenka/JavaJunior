package org.example.sem1.homework1.common;

import org.example.sem1.homework1.common.interfaces.HealthyFood;

/**
 * Курица
 */
public class Chicken implements HealthyFood {
    @Override
    public boolean getProteins() {
        return true;
    }
    @Override
    public boolean getFats() {
        return false;
    }
    @Override
    public boolean getCarbohydrates() {
        return false;
    }
    @Override
    public String getName() {
        return "Курица";
    }
}
