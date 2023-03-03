package by.teachmeskills.homeworks.hw_03032023.animals;

public class Wolf extends Canine {
    public Wolf(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("Woo-woo");
    }

    @Override
    protected void eat() {
        System.out.println("Wolf eats meat");
    }

    @Override
    protected void roam() {
        System.out.println("Wolf lives in a flock");
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "picture='" + picture + '\'' +
                ", food='" + food + '\'' +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                "} " + super.toString();
    }
}