package by.teachmeskills.homeworks.hw_03032023.animals;

public abstract class Canine extends Animal {
    public Canine(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }
    protected abstract void roam();
}
