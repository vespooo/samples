package multithreading.api.synchronizedblock;


public class NotSynchronizedBlock {

    public void method(Counter counter, int numberOfIncrease) {
        for(int i = 0; i< numberOfIncrease; i++){
            counter.increase();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() +" interrupted");
            }
        }
    }
}
