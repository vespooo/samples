package core.instantiationseqence;

public class InstantiationFlowParent {

    static String parentStatic = "Parent static saved to child static";
    {System.out.println("parent non-static block");}

    static {
        System.out.println("parent static block");
        parentStatic = "parent variable was changed in parent static block";
    }
    int parent;

    public InstantiationFlowParent() {
        System.out.println("parent constructor + parent variable's default=" + parent);
    }

    {
        System.out.println("parent non-static block after constructor");
    }
}
