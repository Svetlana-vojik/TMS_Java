package by.teachmeskills.homeworks.hw_03032023.robot.legs;

public class ToshibaLeg implements ILeg {
    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Это нога Toshiba");
    }

    @Override
    public int getPrice() {
        return price;
    }
}