package by.teachmeskills.homeworks.hw_05052023;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(5);
        new Client(sem, 1).start();
        new Client(sem, 2).start();
        new Client(sem, 3).start();
        try {
            Thread.sleep(3000);
            for (int i = 4; i < 20; i++) {
                if (sem.availablePermits() > 1) {
                    System.out.println("Break 10 seconds");
                    Thread.sleep(10000);
                    System.out.println("Shop opens");
                    new Client(sem, i).start();
                } else {
                    new Client(sem, i).start();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}