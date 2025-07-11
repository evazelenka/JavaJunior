package org.example.lec2;

public class Car {
    public String name;
    public String price;
    public String engType;
    public String engPower;
    public int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 100;
        this.price = "10.000.000";
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                '}';
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
