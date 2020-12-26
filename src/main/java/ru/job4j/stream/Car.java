package ru.job4j.stream;

public class Car {

    private String name;
    private String model;
    private int maxSpeed;
    private int weight;
    private int height;
    private int length;
    private int passengersCount;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", height=" + height +
                ", length=" + length +
                ", passengersCount=" + passengersCount +
                '}';
    }

    static class Builder {

        private String name;
        private String model;
        private int maxSpeed;
        private int weight;
        private int height;
        private int length;
        private int passengersCount;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildWeight(int weight) {
            this.weight = weight;
            return this;
        }

        Builder buildHeight(int height) {
            this.height = height;
            return this;
        }

        Builder buildLength(int length) {
            this.length = length;
            return this;
        }

        Builder buildPassengersCount(int passengersCount) {
            this.passengersCount = passengersCount;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.name = name;
            car.model = model;
            car.maxSpeed = maxSpeed;
            car.weight = weight;
            car.height = height;
            car.length = length;
            car.passengersCount = passengersCount;
            return car;
        }
    }

    public static void main(String[] args) {
        Car bmw = new Builder().buildName("BMW")
                .build();
        System.out.println(bmw);

        Car zhiguli = new Builder().buildName("Zhiguli")
                .buildMaxSpeed(20)
                .buildModel("2105")
                .build();
        System.out.println(zhiguli);
    }

}
