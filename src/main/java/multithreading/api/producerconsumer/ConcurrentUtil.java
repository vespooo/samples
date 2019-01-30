package multithreading.api.producerconsumer;

import java.util.List;
import java.util.stream.Collectors;

public class ConcurrentUtil {
    public static void runTwoThreads(Runnable firstThread, Runnable secondThread) {
        try {
            Thread t1 = new Thread(() -> runThread("first", firstThread));
            t1.start();
            Thread.sleep(1000);
            Thread t2 = new Thread(() -> runThread("second", secondThread));
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");;
        }
    }

    private static void runThread(String number, Runnable thread) {
        System.out.println(number + " thread " + Thread.currentThread().getName() + " is run");
        thread.run();
        System.out.println(number + " thread " + Thread.currentThread().getName() + " is finished");
    }

    public static List<Thread> getNonSystemAndNotCurrentThreads() {
        return Thread.getAllStackTraces().keySet().stream()
                .filter(thread -> notCurrentAndNotSystem(thread))
                .collect(Collectors.toList());
    }


    private static boolean notCurrentAndNotSystem(Thread thread) {
        return !thread.getName().equals(Thread.currentThread().getName()) && !thread.isDaemon() && thread.getContextClassLoader() != null;
    }

    public static  void printInfo(String firstInfo, String secondInfo) {
        System.out.println(Thread.currentThread().getName() + " "+firstInfo+" "+secondInfo);
    }
    public static void sleepFor(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }
}