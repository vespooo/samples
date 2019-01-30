package multithreading;

import multithreading.api.producerconsumer.ConcurrentUtil;
import multithreading.api.volatilevariable.NotVolatileConditionLoop;
import multithreading.api.volatilevariable.VolatileConditionLoop;
import org.junit.jupiter.api.Test;

public class VolatileTest {

    @Test
    public void testVolatile(){

        VolatileConditionLoop obj = new VolatileConditionLoop();
        ConcurrentUtil.runTwoThreads(() -> obj.loop(), () -> obj.leaveLoop());
    }

    @Test
    public void testNonVolatile(){

        NotVolatileConditionLoop obj = new NotVolatileConditionLoop();
        ConcurrentUtil.runTwoThreads(() -> obj.loop(), () -> obj.leaveLoop());
    }
}
