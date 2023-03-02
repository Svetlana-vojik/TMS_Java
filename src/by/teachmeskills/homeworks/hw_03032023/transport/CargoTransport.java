package by.teachmeskills.homeworks.hw_03032023.transport;

public class CargoTransport extends GroundTransport {
    private int carryingCapacity;

    public CargoTransport(int power, int maxSpeed, int weight, String brand, int wheelNumber, int fuelConsumption, int carryingCapacity) {
        super(power, maxSpeed, weight, brand, wheelNumber, fuelConsumption);
        this.carryingCapacity = carryingCapacity;
    }

    protected  int getCarryingCapacity() {
        return carryingCapacity;
    }

    protected  void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    protected  void checkCarryingCapacity(int t) {
        if (t <= carryingCapacity) {
            System.out.println("Грузовик загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }
    }

    @Override
    public String toString() {
        return "Грузовой автомобиль - " + super.toString() + "грузоподъемность " + carryingCapacity + " т.";
    }
}