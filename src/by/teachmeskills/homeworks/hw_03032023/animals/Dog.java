package by.teachmeskills.homeworks.hw_03032023.animals;

public class Dog extends Canine{
    public Dog(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("Woof-woof");

    }

    @Override
    protected void eat() {
        System.out.println("Dog eats meat");

    }

    @Override
    protected void roam() {
        System.out.println("Dog lives in a flock");

    }

    @Override
    public String toString() {
        return "Dog{" +
                "picture='" + picture + '\'' +
                ", food='" + food + '\'' +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                "} " + super.toString();
    }
}
