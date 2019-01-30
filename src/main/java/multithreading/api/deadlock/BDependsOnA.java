package multithreading.api.deadlock;

import multithreading.api.producerconsumer.ConcurrentUtil;

import java.util.stream.IntStream;

import static multithreading.api.producerconsumer.ConcurrentUtil.printInfo;

public class BDependsOnA {

    ADependsOnB a;
    synchronized public void method(ADependsOnB a){
        IntStream.range(1,5).forEach(i -> printInfo("BDependsOnA", "method(ADependsOnB a)"));
        a.methodForB();
    }


    synchronized public void methodForA() {
        ConcurrentUtil.printInfo("BDependsOnA", "methodForA()");
    }


}
