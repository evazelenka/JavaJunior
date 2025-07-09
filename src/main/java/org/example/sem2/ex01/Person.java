package org.example.sem2.ex01;

public class Person {
    // region Поля
    private String name;

    private int age;
    // endregion

    //region Конструкторы
    public Person() {
        name = "Name";
        age = 25;
    }
    // endregion

    // region Методы
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void displayInfo(){
        System.out.println(this);
    }
    // endregion
}
