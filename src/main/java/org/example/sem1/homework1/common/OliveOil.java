package org.example.sem1.homework1.common;

import org.example.sem1.homework1.common.interfaces.HealthyFood;

/**
 * Оливковое масло
 */
public class OliveOil implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }
    @Override
    public boolean getFats() {
        return true;
    }
    @Override
    public boolean getCarbohydrates() {
        return false;
    }
    @Override
    public String getName() {
        return "Оливковое масло";
    }
}
