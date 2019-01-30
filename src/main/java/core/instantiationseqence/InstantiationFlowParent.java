package core.instantiationseqence;

public class InstantiationFlowParent {

    {System.out.println("parent non-static block");}
    static {
        System.out.println("parent static block");
    }

    public InstantiationFlowParent() {
        System.out.println("parent constructor");
    }

    {
        System.out.println("parent non-static block after constructor");
    }
}
