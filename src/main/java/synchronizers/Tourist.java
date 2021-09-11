package synchronizers;

import java.util.concurrent.CyclicBarrier;

public class Tourist implements Runnable {
    private static CyclicBarrier barrier;
    private int touristNumber;
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Tourist(CyclicBarrier barrier, int touristNumber) {
        this.barrier = barrier;
        this.touristNumber = touristNumber;
    }

    @Override
    public void run() {
        try {
            System.out.println(ANSI_RED + "Турист " + touristNumber + " пришел в музей и ожидает группу" + ANSI_GREEN);
            barrier.await();
            System.out.println(ANSI_BLACK + "Турист " + touristNumber + " отправился на экскурсию в составе группы" + ANSI_GREEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

