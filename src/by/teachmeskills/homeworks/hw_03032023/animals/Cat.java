package by.teachmeskills.homeworks.hw_03032023.animals;

public class Cat extends Feline {
    public Cat(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("Miaow");
    }

    @Override
    protected void eat() {
        System.out.println("Cat eats meat");
    }

    @Override
    protected void roam() {
        System.out.println("Cat is walking alone!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "picture='" + picture + '\'' +
                ", food='" + food + '\'' +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                "} " + super.toString();
    }
}