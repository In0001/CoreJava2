package queues;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    public static final String ANSI_RED = "\u001B[31m";

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    private long factorial(int number) {
        long fact = 1;
        for (int i = 2; i <= number; i++)
            fact *= i;
        return fact;
    }

    private static int count;

    @Override
    public void run() {
        try {
            while (true) {
                int number = queue.take();
                System.out.println(ANSI_RED + "Найден факториал от числа " + number + ": " + factorial(number));
                count++;
                if (getCount() == Main.producerAmount * Producer.additionsNumber)
                    System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getCount() {
        return count;
    }
}