package org.example.sem1.homework1.common;

import org.example.sem1.homework1.common.interfaces.Snack;

/**
 * Чипсы
 */
public class Crisps implements Snack {
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
        return "Чипсы";
    }
}
