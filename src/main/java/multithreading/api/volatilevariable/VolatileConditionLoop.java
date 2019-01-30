package multithreading.api.volatilevariable;

import multithreading.api.producerconsumer.ConcurrentUtil;

public class VolatileConditionLoop {

    private volatile boolean shouldLeaveLoop;

     public void loop() {
        while (!shouldLeaveLoop){
            Thread thread = Thread.currentThread();
            System.out.println("Thread " + thread.getName() + " is in loop");
            ConcurrentUtil.sleepFor(1000);
        }
    }

    public void leaveLoop(){
        ConcurrentUtil.sleepFor(3000);
        System.out.println("Thread " + Thread.currentThread().getName() + " is changing condition");
        shouldLeaveLoop = true;
    }
}
