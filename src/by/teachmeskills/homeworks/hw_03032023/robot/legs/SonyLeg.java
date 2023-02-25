package by.teachmeskills.homeworks.hw_03032023.robot.legs;

public class SonyLeg implements ILeg {
    private int price;

    public SonyLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Это нога Sony");
    }

    @Override
    public int getPrice() {
        return price;
    }
}