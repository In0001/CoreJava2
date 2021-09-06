package Queues;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
        int producerAmount = 5;
        int consumerAmount = 1;

        for (int i = 0; i < producerAmount; i++) {
            new Thread(new Producer(queue)).start();
        }

        for (int i = 0; i < consumerAmount; i++) {
            new Thread(new Consumer(queue)).start();
        }
    }
}
