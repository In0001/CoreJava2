package ConcurrentCollections;

import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class Adder implements Runnable {
    private final ConcurrentMap<Integer, Integer> map;
    long startTime = System.currentTimeMillis();
    long executionTime = System.currentTimeMillis();
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Adder(ConcurrentMap<Integer, Integer> map) {
        this.map = map;
    }

    private int generateKey() {
        Random key = new Random();
        int minKey = 1;
        int maxKey = 1000;
        return key.nextInt(maxKey) + minKey;
    }

    private int generateNumber() {
        Random rand = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        return rand.nextInt(maxNumber) + minNumber;
    }

    static int count = 0;
    @Override
    public void run() {
        try {
            while (executionTime - startTime < 1000) {
                int key = generateKey();
                int number = generateNumber();
                map.put(key, number);
                System.out.println(ANSI_GREEN + "По ключу " + key + " добавлено значение" + ANSI_BLACK);
                count++;
                executionTime = System.currentTimeMillis();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
