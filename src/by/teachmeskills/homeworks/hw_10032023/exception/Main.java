package by.teachmeskills.homeworks.hw_10032023.exception;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Audi", 180, 15000);
        Car car2 = new Car("BMW", 200, 2000);
        Car car3 = new Car("Ferrari", 250, 50000);

        Car[] cars = {car1, car2, car3};

        for (Car car : cars) {
            try {
                car.start();
            } catch (CarStartException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}