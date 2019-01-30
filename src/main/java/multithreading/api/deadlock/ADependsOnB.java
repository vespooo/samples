package multithreading.api.deadlock;

import multithreading.api.producerconsumer.ConcurrentUtil;

public class ADependsOnB {
    BDependsOnA b;
    synchronized public void method(BDependsOnA b) throws InterruptedException {
        for(int i=0; i<10; i++){
            ConcurrentUtil.printInfo("ADependsOnB", "method");
            Thread.sleep(1000);
        }
        b.methodForA();
    }

    synchronized public void methodForB() {
        ConcurrentUtil.printInfo("ADependsOnB", "methodForB");
    }


}
