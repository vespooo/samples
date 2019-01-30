package multithreading.api.volatilevariable;

import multithreading.api.producerconsumer.ConcurrentUtil;

public class NotVolatileConditionLoop {

    private boolean shouldLeaveLoop = false;

     public void loop() {
        while (!shouldLeaveLoop){
            Thread thread = Thread.currentThread();
//            System.out.println("Thread " + thread.getName() + " changed value to shouldLeaveLoop = false;");
//            shouldLeaveLoop = false;
            System.out.println("Thread " + thread.getName() + " is in loop");
            ConcurrentUtil.sleepFor(100);
        }
    }

    public void leaveLoop(){
        ConcurrentUtil.sleepFor(3000);
        shouldLeaveLoop = true;
        System.out.println("Thread " + Thread.currentThread().getName() + " changed value to shouldLeaveLoop = true;");
        for(int i=0; i<5; i++){
            ConcurrentUtil.printInfo("in", "leaveLoop" );
            ConcurrentUtil.sleepFor(1000);
        }
    }
}
