package queues;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    public static final String ANSI_BLACK = "\u001B[30m";

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    int generateNumber() {
        Random rand = new Random();
        int maxNumber = 5;
        return rand.nextInt(maxNumber) + 1;
    }

    public static long additionsNumber = 10000;

    @Override
    public void run() {
        try {
            for (int i = 0; i < additionsNumber; i++) {
                int number = generateNumber();
                System.out.println(ANSI_BLACK + "В очередь добавлено число " + number);
                queue.put(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
