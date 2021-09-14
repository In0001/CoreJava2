package concurrent.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {
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
    }
}
