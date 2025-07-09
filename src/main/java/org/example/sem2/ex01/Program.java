package org.example.sem2.ex01;

import java.lang.reflect.*;

public class Program {

    /**
     * Задача 1: Основы Reflection API
     * ===============================
     * <p>
     * Получите информацию в классе "Person" с использованием Reflection API:
     * выведете на экран все поля и методы классаю
     * Создайте экземляр класса "Person" с использованием Reflection API,
     * установите значение полей и вызовите методы.
     * Реализуйте обработку исключений для обеспечения корректного взаимодейтсвия
     * с Reflection API.
     * </p>
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("org.example.sem2.ex01.Person");

        // Получить список всех полей
        Field[] fields = personalClass.getDeclaredFields();

        // Получить список всех конструкторов
        Constructor[] constructors = personalClass.getConstructors();

        // Создание экземпляра класса
        Object person = constructors[0].newInstance();

        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person, "Alice");

        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);

        ageField.set(person, 30);

        Method displayInfo = personalClass.getDeclaredMethod("displayInfo");
        displayInfo.invoke(person);
    }
}
