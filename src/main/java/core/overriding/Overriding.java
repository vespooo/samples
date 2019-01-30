package core.overriding;

public class Overriding {

    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println("call parent method from child obj: aa.callHidedVarsInsideParentMethod()");
        aa.callHidedVarsInsideParentMethod();
        System.out.println("As you can see because the method is from parent, vars are from parent, no matter that obj is child instance");
        System.out.println("Child class can use the same name for any var with different access and different type see core/access/AccessModifying.java, call super.s inside child class for parent vars");
        System.out.println("variables are not overriding it's 2 different variables with the same name, it's called hiding");
        System.out.println("because if you create  child obj, you can't access parent var with the same name even if it's public");
        System.out.println("aa.publicS = " + aa.publicS);
        System.out.println("Vars from parent, that is not hided in child may be called from child obj: notOverridden="+aa.notOverridden);

        System.out.println("call aa.callOverriddenMethodsInsideParentMethod");
        aa.callOverriddenMethodsInsideParentMethod();
        System.out.println("As you can see methods except private are overridden");

        System.out.println("call aa.callStaticOverriddenMethodsInsideParentMethod");
        aa.callStaticOverriddenMethodsInsideParentMethod();
        System.out.println("static methods not overridden");
    }
}

class A {
    private String privateS = "parent, private var";
    private static String privateStaticS = "parent, private static";

    protected String protectedS = "parent, protected var";
    protected static String protectedStaticS = "parent, protected static";

    public String publicS = "parent, public var";
    public static String publicStaticS = "parent, public static";

    String s = "parent, var";
    static String staticS = "parent, static";


    private String privateNotOverridden = "parent, private var";
    private static String privateStaticNotOverridden = "parent, private static";

    protected String protectedNotOverridden = "parent, protected var";
    protected static String protectedStaticNotOverridden = "parent, protected static";

    public String publicNotOverridden = "parent, public var";
    public static String publicStaticNotOverridden = "parent, public static";

    String notOverridden = "parent, var";
    static String staticNotOverridden = "parent, static";

    void callHidedVarsInsideParentMethod(){
        System.out.println(privateS);
        System.out.println(privateStaticS);

        System.out.println(protectedS);
        System.out.println(protectedStaticS);

        System.out.println(publicS);
        System.out.println(publicStaticS);

        System.out.println(s);
        System.out.println(staticS);
    }


    void callOverriddenMethodsInsideParentMethod(){
        privateMethod();
        defaultAccessMethod();
        protectedMethod();
        publicMethod();

    }

    void callStaticOverriddenMethodsInsideParentMethod(){
        privateStaticMethod();
        defaultAccessStaticMethod();
        protectedStaticMethod();
        publicStaticMethod();

    }

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

class AA extends A{
    private String privateS = "child, private var";
    private static String privateStaticS = "child, private static";

    protected String protectedS = "child, protected var";
    protected static String protectedStaticS = "child, protected static";

    public String publicS = "child, public var";
    public static String publicStaticS = "child, public static";

    String s = "child, var";
    static String staticS = "child, static";



    private void privateMethod(){
        System.out.println("child privateMethod");
    }

    void defaultAccessMethod(){
        System.out.println("child defaultAccessMethod ");
    }

    protected void protectedMethod(){
        System.out.println("child protectedMethod");
    }

    public void publicMethod(){
        System.out.println("child publicMethod");
    }



    private static void privateStaticMethod(){
        System.out.println("child privateStaticMethod");
    }

    static void defaultAccessStaticMethod(){
        System.out.println("child defaultAccessStaticMethod ");
    }

    protected static void protectedStaticMethod(){
        System.out.println("child protectedStaticMethod");
    }

    public static void publicStaticMethod(){
        System.out.println("child publicStaticMethod");
    }
}