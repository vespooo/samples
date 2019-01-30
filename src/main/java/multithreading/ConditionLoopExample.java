package multithreading;

import multithreading.api.synchronizedmethod.ConditionLoop;
import multithreading.api.producerconsumer.ConcurrentUtil;

public class ConditionLoopExample {

    public static void main(String[] args) throws InterruptedException {
        ConditionLoop loop = new ConditionLoop();
        ConcurrentUtil.runTwoThreads(() -> runOneThread(loop), () -> runAnotherThread(loop));
    }

    private static void runOneThread(ConditionLoop loop) {
        try {
            loop.loop();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runAnotherThread(ConditionLoop loop) {
        loop.leaveLoop();
    }
}
