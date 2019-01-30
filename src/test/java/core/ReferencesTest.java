package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReferencesTest {

    @Test
    public void test()
    {
        References ref = new References();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ref.setA(a);
        ref.setB(b);
        ref.setC(c);
        ref.assign();
        Assertions.assertEquals(ref.getA(),b);
        Assertions.assertEquals(ref.getB(), c);
        Assertions.assertNotEquals(ref.getA(), ref.getB());
    }
}
