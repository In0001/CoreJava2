package Queues;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer implements Runnable {
    private ConcurrentLinkedQueue<Integer> queue;
    public static final String ANSI_BLACK = "\u001B[30m";

    public Producer(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    int generateNumber() {
        Random rand = new Random();
        int maxNumber = 5;
        return rand.nextInt(maxNumber) + 1;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int number = generateNumber();
                System.out.println(ANSI_BLACK + "В очередь добавлено число " + number);
                queue.add(number);
                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
