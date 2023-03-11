package by.teachmeskills.homeworks.hw_10032023.exception;

import java.util.Random;

public class Car {
    private String brand;
    private int speed;
    private int price;
    private boolean flagStart = false;

    public Car(String brand, int speed, int price) {
        this.brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public void start() throws CustomException {
        Random random = new Random();
        int xR = random.nextInt(21);
        if (xR % 2 == 0) {
            throw new CustomException("Ошибка! Cгенерировалось четное число и автомобиль " + brand + " не завелся");
        }
        if (!flagStart) {
            System.out.println("Автомобиль " + brand + " заведён.");
            flagStart = true;
        } else {
            System.out.println("Автомобиль " + brand + " уже заведён.");
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}