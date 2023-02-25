package by.teachmeskills.homeworks.hw_03032023.transport;

public class PassengerTransport extends GroundTransport {
    private String bodyType;
    private int passengerNumber;

    public PassengerTransport(int power, int maxSpeed, int weight, String brand, int wheelNumber, int fuelConsumption, String bodyType, int passengerNumber) {
        super(power, maxSpeed, weight, brand, wheelNumber, fuelConsumption);
        this.bodyType = bodyType;
        this.passengerNumber = passengerNumber;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    private double fuel(double d) {
        return d * getFuelConsumption() / 100;
    }

    public void distanceAtMaxSpeed(double t) {
        double distance = t * getMaxSpeed();
        System.out.println("За время " + t + " ч, автомобиль " + getBrand() + " двигаясь с максимальной скоростью " +
                getMaxSpeed() + " км/ч проедет " + distance + " км и израсходует " + fuel(distance) + " литров топлива.");
    }

    @Override
    public String toString() {
        return "Легковой транспорт - " + super.toString() + " тип кузова = " + bodyType + ", количество пассажиров = " + passengerNumber + " чел.";
    }
}