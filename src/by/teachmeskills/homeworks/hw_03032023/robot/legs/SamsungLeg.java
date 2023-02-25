package by.teachmeskills.homeworks.hw_03032023.robot.legs;

public class SamsungLeg implements ILeg {
    private int price;

    public SamsungLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Это нога Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}