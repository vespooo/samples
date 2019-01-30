package core.instantiationseqence;

public class InstantiationFlowChild extends InstantiationFlowParent {

    {System.out.println("child non-static block");}
    static {
        System.out.println("child static block");
    }

    public InstantiationFlowChild() {
        System.out.println("child constructor");
    }

    {
        System.out.println("child non-static block after constructor");
    }
}
