package multithreading;

import multithreading.api.producerconsumer.ConcurrentUtil;

import java.util.stream.IntStream;

public class JoinExample {
    public static void main(String[] args) {
        ConcurrentUtil.runTwoThreads(() -> firstThreadRun(), () -> secondThreadRun());
    }

    private static void firstThreadRun() {
        IntStream.range(1,5).forEach(i -> {
            System.out.println("First thread is working ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        });

    }

    private static void secondThreadRun() {

        System.out.println("Second thread is working ...");
        System.out.println("Second thread is waiting for second finished ...");
        ConcurrentUtil.getNonSystemAndNotCurrentThreads().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        });
        System.out.println("Second tread finished to wait first thread");
    }
}
