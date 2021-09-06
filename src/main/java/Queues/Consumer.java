package Queues;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable {
    private ConcurrentLinkedQueue<Integer> queue;
    public static final String ANSI_RED = "\u001B[31m";

    public Consumer(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        long fact = 1;
        try {
            while (true) {
                if (queue.size() > 0) {
                    int number = queue.poll();
                    for (int i = 2; i <= number; i++)
                        fact *= i;
                    System.out.println(ANSI_RED + "Найден факториал от числа " + number + ": " + fact);
                    fact = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}