package org.example.sem1.common;

import org.example.sem1.common.interfaces.Thing;

/**
 *  Ручка
 */
public class Pen implements Thing {
    @Override
    public String getName() {
        return "Ручка";
    }
}
