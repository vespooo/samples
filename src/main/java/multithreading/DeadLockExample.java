package multithreading;

import multithreading.api.deadlock.ADependsOnB;
import multithreading.api.deadlock.BDependsOnA;
import multithreading.api.producerconsumer.ConcurrentUtil;

public class DeadLockExample {
    public static void main(String[] args) {
        ADependsOnB a = new ADependsOnB();
        BDependsOnA b = new BDependsOnA();
        ConcurrentUtil.runTwoThreads(() -> firstRun(a, b), () -> secondRun(b, a));
    }

    private static void firstRun(ADependsOnB a, BDependsOnA b) {
        try {
            a.method(b);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }
    private static void secondRun(BDependsOnA b, ADependsOnB a) {
        b.method(a);
    }


}
