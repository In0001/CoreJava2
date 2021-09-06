package ConcurrentCollections;

import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class Deleter implements Runnable {
    private final ConcurrentMap<Integer, Integer> map;
    long startTime = System.currentTimeMillis();
    long executionTime = System.currentTimeMillis();

    public Deleter(ConcurrentMap<Integer, Integer> map) {
        this.map = map;
    }

    private int generateKey() {
        Random key = new Random();
        int minKey = 1;
        int maxKey = 1000;
        return key.nextInt(maxKey) + minKey;
    }

    static int count = 0;
    @Override
    public void run() {
        try {
            while (executionTime - startTime < 1000) {
                int key = generateKey();
                map.remove(key);
                System.out.println("По ключу " + key + " удалено значение");
                count++;
                executionTime = System.currentTimeMillis();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
