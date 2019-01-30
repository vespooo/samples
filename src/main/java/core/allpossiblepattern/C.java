package core.allpossiblepattern;

public class C {
    static {
        System.out.println("parent outer, static block");
    }

    static {
        System.out.println("parent outer, nonstatic block");
    }
    private String privateAccessModified = "parent outer, private var";
    String defaultAccessModified = "parent outer, default var";
    protected String protectedAccessModified = "parent outer, protected var";
    public String publicAccessModified = "parent outer, parent var";

    static private String privateStaticAccessModified = "parent outer, private static";
    static String defaultStaticAccessModified = "parent outer, default static";
    static protected String protectedStaticAccessModified = "parent outer, protected static";
    static public String publicStaticAccessModified = "parent outer, public static";

    C(){
        System.out.println("parent outer, constructor");
        System.out.println("to instantiate class that is in file of another class just instantiate it in general way: new B();");
        new B();
    }

    private void privateMethod(){
        System.out.println("parent outer privateMethod");
    }

    void defaultAccessMethod(){
        System.out.println("parent outer defaultAccessMethod");
    }

    protected void protectedMethod(){
        System.out.println("parent outer protectedMethod");
    }

    public void publicMethod(){
        System.out.println("parent outer publicMethod");
    }



    private static void privateStaticMethod(){
        System.out.println("parent outer privateStaticMethod");
    }

    static void defaultAccessStaticMethod(){
        System.out.println("parent outer defaultAccessStaticMethod ");
    }

    protected static void protectedStaticMethod(){
        System.out.println("parent outer protectedStaticMethod");
    }

    public static void publicStaticMethod(){
        System.out.println("parent outer publicStaticMethod");
    }
}
