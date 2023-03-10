package by.teachmeskills.homeworks.hw_03032023.robot;

import by.teachmeskills.homeworks.hw_03032023.robot.hands.IHand;
import by.teachmeskills.homeworks.hw_03032023.robot.hands.SamsungHand;
import by.teachmeskills.homeworks.hw_03032023.robot.hands.SonyHand;
import by.teachmeskills.homeworks.hw_03032023.robot.hands.ToshibaHand;
import by.teachmeskills.homeworks.hw_03032023.robot.heads.IHead;
import by.teachmeskills.homeworks.hw_03032023.robot.heads.SamsungHead;
import by.teachmeskills.homeworks.hw_03032023.robot.heads.SonyHead;
import by.teachmeskills.homeworks.hw_03032023.robot.heads.ToshibaHead;
import by.teachmeskills.homeworks.hw_03032023.robot.legs.SamsungLeg;
import by.teachmeskills.homeworks.hw_03032023.robot.legs.SonyLeg;
import by.teachmeskills.homeworks.hw_03032023.robot.legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        SamsungHead samsungHead = new SamsungHead(10);
        SamsungHand samsungHand = new SamsungHand(10);
        SamsungLeg samsungLeg = new SamsungLeg(10);

        SonyHead sonyHead = new SonyHead(5);
        SonyHand sonyHand = new SonyHand(1);
        SonyLeg sonyLeg = new SonyLeg(1);

        ToshibaHead toshibaHead = new ToshibaHead(36);
        ToshibaHand toshibaHand = new ToshibaHand(29);
        ToshibaLeg toshibaLeg = new ToshibaLeg(4);

        Robot robot1 = new Robot(samsungHead, sonyHand, toshibaLeg);
        Robot robot2 = new Robot(samsungHead, toshibaHand, sonyLeg);
        Robot robot3 = new Robot(toshibaHead, samsungHand, toshibaLeg);

        Robot[] robots = {robot1, robot2, robot3};
        for (Robot robot : robots) {
            robot.action();
            System.out.println("-------------------------------");

            if (robot1.getPrice() > robot2.getPrice() && robot1.getPrice() > robot3.getPrice()) {
                System.out.println("Самый дорогой робот - robot1");
            } else if (robot2.getPrice() > robot1.getPrice() && robot2.getPrice() > robot3.getPrice()) {
                System.out.println("Самый дорогой робот - robot2");
            } else {
                System.out.println("Самый дорогой робот - robot3");
            }
        }
    }
}