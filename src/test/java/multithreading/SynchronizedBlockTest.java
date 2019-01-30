package multithreading;

import multithreading.api.synchronizedblock.NotVolatileCounter;
import multithreading.api.synchronizedblock.NotSynchronizedBlock;
import multithreading.api.producerconsumer.ConcurrentUtil;
import multithreading.api.synchronizedblock.SynchronizedBlock;
import multithreading.api.synchronizedblock.VolatileCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class SynchronizedBlockTest {

    @RepeatedTest(10)
    public void testNotSync(){
        NotVolatileCounter counter = new NotVolatileCounter();
        NotSynchronizedBlock nsb = new NotSynchronizedBlock();
        ConcurrentUtil.runTwoThreads(() -> nsb.method(counter, 100), () -> nsb.method(counter, 100));
        Assertions.assertEquals(200, counter.getNum());
    }

    @RepeatedTest(10)
    public void testSync(){
        NotVolatileCounter counter = new NotVolatileCounter();
        SynchronizedBlock sb = new SynchronizedBlock();
        ConcurrentUtil.runTwoThreads(() -> sb.method(counter, 100), () -> sb.method(counter, 100));
        Assertions.assertEquals(200, counter.getNum());
    }

    @RepeatedTest(10)
    public void testVolatile(){
        VolatileCounter counter = new VolatileCounter();
        NotSynchronizedBlock nsb = new NotSynchronizedBlock();
        ConcurrentUtil.runTwoThreads(() -> nsb.method(counter, 100), () -> nsb.method(counter, 100));
        Assertions.assertEquals(200, counter.getNum());
    }
}
