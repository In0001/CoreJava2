package ConcurrentCollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static void main(String[] args) {
        ConcurrentMap<Integer,Integer> map = new ConcurrentHashMap<>();

        Thread adder1 = new Thread(new Adder(map));
        Thread adder2 = new Thread(new Adder(map));
        Thread deleter1 = new Thread(new Deleter(map));
        Thread deleter2 = new Thread(new Deleter(map));

        adder1.start();
        adder2.start();
        deleter1.start();
        deleter2.start();

        while (adder1.isAlive() || adder2.isAlive() || deleter1.isAlive() || deleter1.isAlive()) {
            continue;
        }
        System.out.println(ANSI_RED + "За секунду произведено операций вставики: " + Adder.count + ANSI_BLACK);
        System.out.println(ANSI_RED + "За секунду произведено операций удаления: " + Deleter.count + ANSI_BLACK);
    }
}
