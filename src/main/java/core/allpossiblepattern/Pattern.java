package core.allpossiblepattern;

public class Pattern {
    //nonstattic inner cannot contain static content
    class InnerParent{

        private String innerParentPrivateS = "inner parent, private var";
        String innerParentDefault = "inner parent, default access var";
        protected String innerParentProtected = "inner parent, protected var";
        public String innerParentPublicS = "inner parent, public var";

        {
            System.out.println("inner parent, non-static init block");
        }

        InnerParent(){
            System.out.println(" inner parent constructor");
        }

        private void innerParentPrivateMethod(){
            System.out.println("inner parent privateMethod");
        }

        void innerParentDefaultAccessMethod(){
            System.out.println("inner parent defaultAccessMethod");
        }

        protected void innerParentProtectedMethod(){
            System.out.println("inner parent protectedMethod");
        }

        public void innerParentPublicMethod(){
            System.out.println("inner parent publicMethod");
        }

    }

    class InnerChild extends InnerParent{

        private String innerChildPrivate = "inner child, private var";
        String innerChildDefault = "inner child, default access var";
        protected String innerChildProtectedS = "inner child, protected var";
        public String innerChildPublic = "inner child, public var";

        {
            System.out.println("inner child class, initialisation block after constructor");
        }

        InnerChild(){
            System.out.println(" inner child constructor");
        }

        private void innerChildPrivateMethod(){
            System.out.println("inner child privateMethod");
        }

        void innerChildDefaultAccessMethod(){
            System.out.println("inner child defaultAccessMethod ");
        }

        protected void innerChildProtectedMethod(){
            System.out.println("inner child protectedMethod");
        }

        public void innerChildPublicMethod(){
            System.out.println("inner child publicMethod");
        }

    }

    //static class can be only inner
    static class StaticInnerParent{
        static{
            System.out.println("Inner static parent, static block");
        }

        {
            System.out.println("inner static parent, non-static init block");
        }

        private String staticInnerParentPrivateS = "inner parent static, private var";
        String staticInnerParentDefault = "inner parent static, default access var";
        protected String protectedS = "inner parent static, protected var";
        public String staticInnerParentPublic = "inner parent static, public var";

        static private String staticInnerParentPrivateStatic = "inner parent static, static private var";
        static String staticInnerParentDefaultStatic = "inner parent static, static default access var";
        static protected String staticInnerParentProtectedStatic = "inner parent static, static protected var";
        static public String staticInnerParentPublicStatic = "inner parent static, static public var";

        StaticInnerParent(){
            System.out.println(" inner parent constructor");
        }

        private void staticInnerParentPrivateMethod(){
            System.out.println("inner parent privateMethod");
        }

        void staticInnerParentDefaultAccessMethod(){
            System.out.println("inner parent defaultAccessMethod");
        }

        protected void staticInnerParentProtectedMethod(){
            System.out.println("inner parent protectedMethod");
        }

        public void staticInnerParentPublicMethod(){
            System.out.println("inner parent publicMethod");
        }


        static private void staticInnerParentPrivateStaticMethod(){
            System.out.println("inner parent privateStaticMethod");
        }

        static void staticInnerParentDefaultAccessStaticMethod(){
            System.out.println("inner parent defaultAccessStaticMethod");
        }

        static protected void staticInnerParentProtectedStaticMethod(){
            System.out.println("inner parent protectedStaticMethod");
        }

        static public void staticInnerParentPublicStaticMethod(){
            System.out.println("inner parent publicMStaticethod");
        }
    }

    static class StaticInnerChild extends StaticInnerParent{
        static{
            System.out.println("Inner static child, static block");
        }

        {
            System.out.println("inner static child, non-static init block");
        }

        private String staticInnerChildPrivateS = "inner child static, private var";
        String staticInnerChildDeffault = "inner child static, default access var";
        protected String staticInnerChildProtectedS = "inner child static, protected var";
        public String staticInnerChildPublicS = "inner child static, public var";

        static private String staticInnerChildPrivateStatic = "inner child static, static private var";
        static String staticInnerChildDefaultStatic = "inner child static, static default access var";
        static protected String staticInnerChildProtectedStatic = "inner child static, static protected var";
        static public String staticInnerChildPublicStatic = "inner child static, static public var";

        StaticInnerChild(){
            System.out.println(" inner child constructor");
        }

        private void staticInnerChildPrivateMethod(){
            System.out.println("inner child privateMethod");
        }

        void staticInnerChildDefaultAccessMethod(){
            System.out.println("inner child defaultAccessMethod");
        }

        protected void staticInnerChildProtectedMethod(){
            System.out.println("inner child protectedMethod");
        }

        public void staticInnerChildPublicMethod(){
            System.out.println("inner child publicMethod");
        }


        private void staticInnerChildPrivateStaticMethod(){
            System.out.println("inner child privateStaticMethod");
        }

        static void staticInnerChildDefaultAccessStaticMethod(){
            System.out.println("inner child defaultAccessStaticMethod");
        }

        static protected void staticInnerChildProtectedStaticMethod(){
            System.out.println("inner child protectedStaticMethod");
        }

        static public void staticInnerChildPublicStaticMethod(){
            System.out.println("inner child publicMStaticethod");
        }

    }

    static {
       System.out.println("Main class, static block");
    }

    {
        System.out.println("Main class, nonstatic block");
    }

    private String privateS = "main static, private var";
    String s = "main static, default access var";
    protected String protectedS = "main static, protected var";
    public String publicS = "main static, public var";

    static private String privateStatic = "main static, static private var";
    static String defaultStatic = "main static, static default access var";
    static protected String protectedStatic = "main static, static protected var";
    static public String publicStatic = "main static, static public var";


    Pattern(){
        System.out.println(" Main class, constructor");
    }

    private void privateMethod(){
        System.out.println("main privateMethod");
    }

    void defaultAccessMethod(){
        System.out.println("main defaultAccessMethod");
    }

    protected void protectedMethod(){
        System.out.println("main protectedMethod");
    }

    public void publicMethod(){
        System.out.println("main publicMethod");
    }


    static private void privateStaticMethod(){
        System.out.println("main privateStaticMethod");
    }

    static void defaultAccessStaticMethod(){
        System.out.println("main defaultAccessStaticMethod");
    }

    static protected void protectedStaticMethod(){
        System.out.println("main protectedStaticMethod");
    }

    static public void publicStaticMethod(){
        System.out.println("main publicMStaticethod");
    }


    public static void main(String[] args) {
 StaticInnerParent s = new StaticInnerParent();

   }
}

/*can't be public, only class with the same name as file can be pblic*/
class B {

    static {
        System.out.println("parent, static block");
    }

    static {
        System.out.println("parent, nonstatic block");
    }

    private String privateAccessModified = "parent, private var";
    String defaultAccessModified = "parent, default var";
    protected String protectedAccessModified = "parent, protected var";
    public String publicAccessModified = "parent, parent var";

    static private String privateStaticAccessModified = "parent, private static";
    static String defaultStaticAccessModified = "parent, default static";
    static protected String protectedStaticAccessModified = "parent, protected static";
    static public String publicStaticAccessModified = "parent, public static";

    B(){
        System.out.println("parent, constructor");
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

class BB extends B {

    static {
        System.out.println("child, static block");
    }

    static {
        System.out.println("child, nonstatic block");
    }


    private String privateAccessModified = "child, private var";
    String defaultAccessModified = "child, default var";
    protected String protectedAccessModified = "child, protected var";
    public String publicAccessModified = "child, public var";

    static private String privateStaticAccessModified = "child, private static";
    static String defaultStaticAccessModified = "child, default static";
    static protected String protectedStaticAccessModified = "child, protected static";
    static public String publicStaticAccessModified = "child, public static";

    BB(){
        System.out.println("child, constructor");
    }

    public int privateMethod(){
        System.out.println("child privateMethod");
        return 0;
    }

    protected void defaultAccessMethod(){
        System.out.println("child defaultAccessMethod");
    }

    public void protectedMethod(){
        System.out.println("child protectedMethod");
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