package concurrentCollections;

import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class Deleter implements Runnable {
    private final ConcurrentMap<Integer, Integer> map;
    long startTime = System.currentTimeMillis();
    long executionTime = System.currentTimeMillis();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public Deleter(ConcurrentMap<Integer, Integer> map) {
        this.map = map;
    }

    private int generateKey() {
        Random key = new Random();
        int minKey = 1;
        int maxKey = 1000;
        return key.nextInt(maxKey) + minKey;
    }

    private static int deletion = 0;

    @Override
    public void run() {
        try {
            while (executionTime - startTime < 1000) {
                int key = generateKey();
                map.remove(key);
                System.out.println("По ключу " + key + " удалено значение");
                deletion++;
                executionTime = System.currentTimeMillis();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadCount();
        }
    }

    private static int count = 0;
    private void threadCount() {
        count++;
        if (count == 2)
            printResult();
    }

    private void printResult() {
        System.out.println(ANSI_RED + "За секунду произведено операций удаления: " + deletion + ANSI_BLACK);
    }
}
