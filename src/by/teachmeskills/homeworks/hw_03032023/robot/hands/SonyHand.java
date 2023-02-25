package by.teachmeskills.homeworks.hw_03032023.robot.hands;

public class SonyHand implements IHand {
    private int price;

    public SonyHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Рука Sony поднята");
    }

    @Override
    public int getPrice() {
        return price;
    }
}