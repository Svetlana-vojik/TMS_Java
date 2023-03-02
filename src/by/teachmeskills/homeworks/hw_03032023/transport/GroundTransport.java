package by.teachmeskills.homeworks.hw_03032023.transport;

public class GroundTransport extends Transport {
    private int wheelNumber;
    private double fuelConsumption;

    public GroundTransport(int power, int maxSpeed, int weight, String brand, int wheelNumber, double fuelConsumption) {
        super(power, maxSpeed, weight, brand);
        this.wheelNumber = wheelNumber;
        this.fuelConsumption = fuelConsumption;
    }

    protected int getWheelNumber() {
        return wheelNumber;
    }

    protected void setWheelNumber(int wheelNumber) {
        this.wheelNumber = wheelNumber;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return super.toString() + " количество колес = " + wheelNumber + " шт., расход топлива " + fuelConsumption + " литр/100км., ";
    }
}

