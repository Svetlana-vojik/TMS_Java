package by.teachmeskills.homeworks.hw_03032023.transport;

public class Transport {
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

    protected double horsePowerToKW() {
        return power * 0.74;
    }

       public String toString() {
        return "мощность = " + power +
                " лошадиная сила или " + horsePowerToKW() + " кВ, макисмальная скорость = " + maxSpeed +
                " км/ч, масса = " + weight + " тонн, марка = " + brand + ", ";
    }
}