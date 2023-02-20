package by.teachmeskills.homeworks.hw_24022023;

import java.util.Scanner;

public class Computer {
    private String processor;
    private int ram;
    private int hardDiscCapacity;

    public Computer(String processor, int ram, int hardDiscCapacity) {
        this.processor = processor;
        this.ram = ram;
        this.hardDiscCapacity = hardDiscCapacity;
    }

    public void info() {
        System.out.printf("Processor type is %s, amount of RAM is %d, hard disk capacity is %d \n", processor, ram, hardDiscCapacity);
    }

    public void turnOn() {
        Scanner scan = new Scanner(System.in);
        Scanner random;
        int i = (int) (Math.random() * 2);
        System.out.print("Введите число 0 или 1: ");
        int num = scan.nextInt();

        if (i != num) {
            System.out.println("Компьютер включен");
        } else {
            System.out.println("Компьютер сгорел");
        }
    }

    public void turnOff() {
        Scanner scanner = new Scanner(System.in);
        Scanner random;
        int i = (int) (Math.random() * 2);
        System.out.print("Введите число 0 или 1: ");
        int num = scanner.nextInt();

        if (i != num) {
            System.out.println("Компьютер выключен");
        } else if (i == num)
            System.out.println("Компьютер сгорел");
    }
}