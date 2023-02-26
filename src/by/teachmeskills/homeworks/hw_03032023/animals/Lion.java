package by.teachmeskills.homeworks.hw_03032023.animals;

public class Lion extends Feline{
    public Lion(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("R-R-R-R-R-");
    }

    @Override
    protected void eat() {
        System.out.println("Lion eats meat");

    }

    @Override
    protected void roam() {
        System.out.println("Lion is walking alone!");

    }

    @Override
    public String toString() {
        return "Lion{" +
                "picture='" + picture + '\'' +
                ", food='" + food + '\'' +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                "} " + super.toString();
    }
}
