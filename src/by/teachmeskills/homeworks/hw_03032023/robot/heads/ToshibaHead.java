package by.teachmeskills.homeworks.hw_03032023.robot.heads;

import by.teachmeskills.homeworks.hw_03032023.robot.heads.IHead;

public class ToshibaHead implements IHead {
    private int price;

    public ToshibaHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Говорит голова Toshiba");
    }

    @Override
    public int getPrice() {
        return price;
    }
}