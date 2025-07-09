package org.example.sem1.common;

import org.example.sem1.common.interfaces.Thing;

/**
 *  Блокнот
 */
public class Notebook implements Thing {
    @Override
    public String getName() {
        return "Блокнот";
    }
}
