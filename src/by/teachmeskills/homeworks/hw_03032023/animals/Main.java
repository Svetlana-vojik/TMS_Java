package by.teachmeskills.homeworks.hw_03032023.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Feline cat = new Cat("Cat.jpg", "meat", 5, new Animal.Boundaries(20, 20), new Animal.Location(15, 15));
        Feline tiger = new Tiger("Tiger.jpg", "meat", 10, new Animal.Boundaries(50, 30), new Animal.Location(25, 25));
        Feline lion = new Lion("Lion.jpg", "meat", 7, new Animal.Boundaries(30, 20), new Animal.Location(55, 15));
        Animal hippo = new Hippo("Hippo.jpg", "grass", 4, new Animal.Boundaries(10, 50), new Animal.Location(20, 30));
        Canine dog = new Dog("Dog.jpg", "meat", 5, new Animal.Boundaries(80, 10), new Animal.Location(15, 15));
        Canine wolf = new Wolf("Wolf.jpg", "meat", 5, new Animal.Boundaries(70, 50), new Animal.Location(15, 75));

        Animal[] animals = {cat, tiger, lion, hippo, dog, wolf};
        for (Animal animal : animals) {
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            animal.roam();
            System.out.println("-----------------------------------------");

            Feline[] felines = {cat, lion, tiger};
            for (Feline feline : felines) {
                feline.makeNoise();
                feline.eat();
                feline.roam();
                System.out.println("--------------------------------------");
            }

            Canine[] canines = {dog, wolf};
            for (Canine canine : canines) {
                canine.roam();
                canine.makeNoise();
                canine.eat();
                System.out.println("--------------------------------------");
            }
        }
    }
}