package by.teachmeskills.homeworks.hw_17032023.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Audi", 180, 50000);
        try {
            FileOutputStream fos = new FileOutputStream("src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\car.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(car);
            System.out.println(car);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileInputStream fis = new FileInputStream("src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\car.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Car car1 = (Car) ois.readObject();
            System.out.println(car1);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}