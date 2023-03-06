package by.teachmeskills.homeworks.hw_03032023.transport;

public abstract class Transport {
    protected int power;
    protected int maxSpeed;
    protected int weight;
    protected String brand;

    public Transport(int power, int maxSpeed, int weight, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    protected double horsePowerToKW() {
        return power * 0.74;
    }

    public String toString() {
        return "мощность = " + power +
                " лошадиная сила или " + horsePowerToKW() + " кВ, макисмальная скорость = " + maxSpeed +
                " км/ч, масса = " + weight + " тонн, марка = " + brand + ", ";
    }
}