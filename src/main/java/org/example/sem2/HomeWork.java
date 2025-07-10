package org.example.sem2;

import java.lang.reflect.Method;

public class HomeWork {
    /**
     * Используя Reflection API, напишите программу,
     * которая выводит на экран все методы класса String.
     */
    public static void main(String[] args) {
        String str = new String();
        Method[] methods = str.getClass().getMethods();
        for (Method m : methods){
            System.out.println(m.toString());
        }
    }
}
