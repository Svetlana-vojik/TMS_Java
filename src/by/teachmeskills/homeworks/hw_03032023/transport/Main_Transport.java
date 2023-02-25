package by.teachmeskills.homeworks.hw_03032023.transport;

import java.util.Scanner;

public class Main_Transport {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CargoTransport cargoTransport = new CargoTransport(500, 90, 7, "Mercedes", 4, 20, 9);
        CivilTransport civilTransport = new CivilTransport(200, 800, 12, "Boeing", 5, 2000, 350, true);
        MilitaryTransport militaryTransport = new MilitaryTransport(500, 500, 8, "Boeing", 4, 4000, false, 3);
        PassengerTransport passengerTransport = new PassengerTransport(600, 120, 3, "BMW", 6, 12, "Universal", 8);

        System.out.println(cargoTransport.toString());
        System.out.println(civilTransport.toString());
        System.out.println(militaryTransport.toString());
        System.out.println(passengerTransport.toString());

        //Проверки Грузового транспорта
        System.out.println();
        System.out.println("Грузоподъемность грузовика " + cargoTransport.getBrand() + " = " + cargoTransport.getCarryingCapacity() + " тонн");
        System.out.println("Сколько тон груза вы хотите загрузить?");
        int t = scan.nextInt();
        cargoTransport.checkCarryingCapacity(t);

        //Проверки гражданского самолета
        System.out.println();
        System.out.println("У гражданского самолета " + civilTransport.getBrand() + " посадочных мест = " + civilTransport.getPassengerNumber());
        System.out.println("Сколько посадочных мест необходимо?");
        int p = scan.nextInt();
        civilTransport.checkPassengerNumber(p);

        //Проверки военного самолета
        System.out.println();
        System.out.println("Количество ракет на борту военного самолета " + militaryTransport.getBrand() + " = " + militaryTransport.getRocketsOnBoard());
        System.out.println("Сколько ракет нужно выпустить");
        int r = scan.nextInt();
        militaryTransport.shot(r);
        militaryTransport.checkEjectionSystem();

        //Проверки легкового транспорта
        System.out.println();
        passengerTransport.distanceAtMaxSpeed(1.5);

    }
}