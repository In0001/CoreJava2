package queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static int queueSize = 100;
    public static int producerAmount = 5;
    public static int consumerAmount = 1;

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(queueSize);

        for (int i = 0; i < producerAmount; i++) {
            new Thread(new Producer(queue)).start();
        }

        for (int i = 0; i < consumerAmount; i++) {
            new Thread(new Consumer(queue)).start();
        }
    }
}
