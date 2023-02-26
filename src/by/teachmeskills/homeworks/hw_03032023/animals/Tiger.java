package by.teachmeskills.homeworks.hw_03032023.animals;

public class Tiger extends Feline {
    public Tiger(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("R-r-r-r-r-r");
    }

    @Override
    protected void eat() {
        System.out.println("Tiger eats meat");
    }

    @Override
    protected void roam() {
        System.out.println("Tiger is walking alone!");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "picture='" + picture + '\'' +
                ", food='" + food + '\'' +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                "} " + super.toString();
    }
}
