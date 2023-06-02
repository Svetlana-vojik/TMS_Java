package by.teachmeskills.homeworks.hw_14042023.lambda2.box;

public class HeavyBox {
    public int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return weight + " кг.";
    }
}