package core.instantiationseqence;

public class InstantiationFlowChild extends InstantiationFlowParent {

    static String childStatic = InstantiationFlowParent.parentStatic;
    {System.out.println("child non-static block");}

    static {
        System.out.println("child static block");
        System.out.println(childStatic);
    }
    int b = 3;
    public InstantiationFlowChild() {
        System.out.println("child constructor");
    }

    {
        System.out.println("child non-static block after constructor");
    }
}
