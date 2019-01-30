package core.access;

public class AccessModifying {
    public static void main(String[] args) {
        A a = new A();
        AA aa = new AA();
        System.out.println("vars with the same name in child can change access modifier and type:");
        System.out.println("AAA.publicAccessModified=" + a.publicAccessModified);
        System.out.println("aa.publicAccessModified=" + aa.publicAccessModified + ", access changed to default, type to int");

        System.out.println("private methods are not overriding, so as vars can change access and type to any");
        System.out.println("aa.privateMethod() is public now and return int: " + aa.privateMethod());
        System.out.println("default, protected methods can change modifier to less weaker:");
        System.out.println("call aa.defaultAccessMethod():");
        aa.defaultAccessMethod();
        System.out.println("call aa.protectedMethod():");
        aa.protectedMethod();

        System.out.println("static method the same rules(less weaker modifier, except private) but they are not overriding");
    }
}

class A {

    private String privateAccessModified = "parent, private var";
    private static String privateStaticAccessModified = "parent, private static";

    String defaultAccessModified = "parent, var";
    static String defaultStaticAccessModified = "parent, default static";

    protected String protectedAccessModified = "parent, protected var";
    protected static String protectedStaticAccessModified = "parent, protected static";

    public String publicAccessModified = "parent, public var";
    public static String publicStaticAccessModified = "parent, public static";


    private void privateMethod(){
        System.out.println("parent privateMethod");
    }

    void defaultAccessMethod(){
        System.out.println("parent defaultAccessMethod");
    }

    protected void protectedMethod(){
        System.out.println("parent protectedMethod");
    }

    public void publicMethod(){
        System.out.println("parent publicMethod");
    }



    private static void privateStaticMethod(){
        System.out.println("parent privateStaticMethod");
    }

    static void defaultAccessStaticMethod(){
        System.out.println("parent defaultAccessStaticMethod ");
    }

    protected static void protectedStaticMethod(){
        System.out.println("parent protectedStaticMethod");
    }

    public static void publicStaticMethod(){
        System.out.println("parent publicStaticMethod");
    }
}

class AA extends AAA {

    public int privateAccessModified = 1;
    public static int privateStaticAccessModified = 1;

    private int protectedAccessModified = 1;
    private static int protectedStaticAccessModified = 1;

    int publicAccessModified = 1;
    private static int publicStaticAccessModified = 1;

    public int defaultAccessModified = 1;
    private static int defaultStaticAccessModified = 1;


    public int privateMethod(){
        System.out.println("child privateMethod not overridden, can change access and type to any");
        return 0;
    }

    protected void defaultAccessMethod(){
        System.out.println("child defaultAccessMethod, can change access to less weaker, i.e to : protected and public");
    }

    public void protectedMethod(){
        System.out.println("child protectedMethod, can change access to less weaker, i.e to : public");
    }

    public void publicMethod(){
        System.out.println("child publicMethod");
    }



    private static int privateStaticMethod(){
        System.out.println("child privateStaticMethod");
        return 0;
    }

    protected static void defaultAccessStaticMethod(){
        System.out.println("child defaultAccessStaticMethod ");
    }

    public static void protectedStaticMethod(){
        System.out.println("child protectedStaticMethod");
    }

    public static void publicStaticMethod(){
        System.out.println("child publicStaticMethod");
    }
}