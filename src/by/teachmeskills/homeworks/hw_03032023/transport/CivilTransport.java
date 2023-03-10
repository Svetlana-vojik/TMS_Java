package by.teachmeskills.homeworks.hw_03032023.transport;

public class CivilTransport extends AirTransport {
    private int passengerNumber;
    private boolean businessClass;

    public CivilTransport(int power, int maxSpeed, int weight, String brand, int wingspan, int minimumRunwayLength, int passengerNumber, boolean businessClass) {
        super(power, maxSpeed, weight, brand, wingspan, minimumRunwayLength);
        this.passengerNumber = passengerNumber;
        this.businessClass = businessClass;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public boolean isBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        this.businessClass = businessClass;
    }

    public void checkPassengerNumber(int p) {
        if (p <= passengerNumber) {
            System.out.println("Самолет загружен");
        } else {
            System.out.println("Вам нужен самолет побольше");
        }
    }

    @Override
    public String toString() {
        return "Граждансикий самолет - " + super.toString() + " количество пассажиров " + passengerNumber + " бизнес-класс " + businessClass + ".";
    }
}