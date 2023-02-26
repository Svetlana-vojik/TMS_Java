package by.teachmeskills.homeworks.hw_03032023.animals;

public abstract class Feline extends Animal {
    public Feline(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }
    protected abstract void roam();
}