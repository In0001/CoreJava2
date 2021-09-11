package synchronizers;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {
    private static final int groupSize = 10;

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(groupSize, new Group());
        int museumOpeningHours = 10000;
        int i = 0, k = 0;

        long startTime = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis();
        while (executionTime - startTime < museumOpeningHours){
            i++;
            new Thread(new Tourist(barrier, i)).start();
            Thread.sleep(generateNumber());
            if (i % 10 == 0)
                k = i;

            executionTime = System.currentTimeMillis();
        }

        System.out.println("Музей закрылся");
        System.out.printf("В составе группы музей посетило %d человек\n", k);
        System.exit(0);
    }

    static int generateNumber() {
        Random rand = new Random();
        int maxNumber = 400;
        return rand.nextInt(maxNumber);
    }
}
