package core.allpossiblepattern;

public class CC extends C {
    static {
        System.out.println("child outer, static block");
    }

    static {
        System.out.println("child outer, nonstatic block");
    }


    private String privateAccessModified = "child outer, private var";
    String defaultAccessModified = "child outer, default var";
    protected String protectedAccessModified = "child outer, protected var";
    public String publicAccessModified = "child outer, public var";

    static private String privateStaticAccessModified = "child outer, private static";
    static String defaultStaticAccessModified = "child outer, default static";
    static protected String protectedStaticAccessModified = "child outer, protected static";
    static public String publicStaticAccessModified = "child outer, public static";

    CC(){
        System.out.println("child outer, constructor");
    }

    public int privateMethod(){
        System.out.println("child outer privateMethod");
        return 0;
    }

    protected void defaultAccessMethod(){
        System.out.println("child outer defaultAccessMethod");
    }

    public void protectedMethod(){
        System.out.println("child outer protectedMethod");
    }

    public void publicMethod(){
        System.out.println("child outer publicMethod");
    }



    private static int privateStaticMethod(){
        System.out.println("child outer privateStaticMethod");
        return 0;
    }

    protected static void defaultAccessStaticMethod(){
        System.out.println("child outer defaultAccessStaticMethod ");
    }

    public static void protectedStaticMethod(){
        System.out.println("child outer protectedStaticMethod");
    }

    public static void publicStaticMethod(){
        System.out.println("child outer publicStaticMethod");
    }

}
