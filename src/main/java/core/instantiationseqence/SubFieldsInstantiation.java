package core.instantiationseqence;

import java.util.concurrent.Future;

public class SubFieldsInstantiation extends FieldsInstantiation {
    {
        System.out.println("a inside sub = "+ a);
        System.out.println("b inside sub = "+ b);
    }
    private int c = a;
    {
        System.out.println("c="+c);
    }
    public SubFieldsInstantiation(int q) throws Exception {
        System.out.println("inside the subconstructor");
    }
}
