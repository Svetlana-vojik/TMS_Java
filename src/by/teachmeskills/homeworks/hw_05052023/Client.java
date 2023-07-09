package by.teachmeskills.homeworks.hw_05052023;

import java.util.concurrent.Semaphore;

public class Client extends Thread {
    Semaphore sem;
    int id;

    public Client(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            System.out.println("Client " + id + " are in the shop.");
            Thread.sleep((int) (Math.random() * 8000 + 1000));
            System.out.printf("Client " + id + " leaves the shop.\n");
            sem.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}