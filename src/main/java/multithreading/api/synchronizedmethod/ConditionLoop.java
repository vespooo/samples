package multithreading.api.synchronizedmethod;

import multithreading.api.producerconsumer.ConcurrentUtil;

import java.util.List;

public class ConditionLoop {

    private boolean shouldLeaveLoop;

     synchronized public void loop() throws InterruptedException {
        while (!shouldLeaveLoop){
            Thread thread = Thread.currentThread();
            System.out.println("Thread " + thread.getName() + " is in loop");
            wait(1000);
        }
    }

    public void leaveLoop(){
        System.out.println("Thread " + Thread.currentThread().getName() + " is changing condition");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //notifyAll();
        //interruptAnotherThreads();
        shouldLeaveLoop = true;
    }

    public void interruptAnotherThreads() {
        List<Thread> threads = ConcurrentUtil.getNonSystemAndNotCurrentThreads();
        threads.forEach(thread -> thread.interrupt());
    }

}
