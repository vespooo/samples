package multithreading.api.synchronizedblock;

public class SynchronizedBlock {

    public void method(Counter counter, int numberOfIncrease) {
        for(int i = 0; i< numberOfIncrease; i++){
            synchronized (counter){
                counter.increase();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() +" interrupted");
            }
        }
    }
}
