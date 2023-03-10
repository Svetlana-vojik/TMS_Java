package by.teachmeskills.homeworks.hw_03032023.animals;

public class Hippo extends Animal {
    public Hippo(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("Growl-growl-growl");
    }

    @Override
    protected void eat() {
        System.out.println("Hippo eats grass");
    }

    @Override
    public String toString() {
        return "Hippo{" +
                "picture='" + picture + '\'' +
                ", food='" + food + '\'' +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                "} " + super.toString();
    }
}