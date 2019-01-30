package multithreading;

import multithreading.api.synchronizedblock.NotVolatileCounter;
import multithreading.api.producerconsumer.ConcurrentUtil;

public class SynchronizedBlockExample {
    public static void main(String[] args) {
        NotVolatileCounter counter1 = new NotVolatileCounter();
        ConcurrentUtil.runTwoThreads(() -> firstRun(counter1), () -> secondRun(counter1));
        ConcurrentUtil.printInfo("increased to", Integer.toString(counter1.getNum()));

        NotVolatileCounter counter2 = new NotVolatileCounter();
        ConcurrentUtil.runTwoThreads(() -> firstRunWithSync(counter2), () -> secondRunWithSync(counter2));
        ConcurrentUtil.printInfo("increased to", Integer.toString(counter2.getNum()));
    }

    private static void firstRunWithSync(NotVolatileCounter counter){
        for(int i=0; i<100; i++){
            synchronized (counter){
                counter.increase();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("firstRun interrupted");
            }
        }

    }

    private static void secondRunWithSync(NotVolatileCounter counter){
        for(int i=0; i<100; i++){

            synchronized (counter){
                counter.increase();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("firstRun interrupted");
            }
        }

    }

    private static void firstRun(NotVolatileCounter counter){
        for(int i=0; i<100; i++){
                counter.increase();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("firstRun interrupted");
            }
        }

    }

    private static void secondRun(NotVolatileCounter counter){
        for(int i=0; i<100; i++){
                counter.increase();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("firstRun interrupted");
            }
        }

    }
}
