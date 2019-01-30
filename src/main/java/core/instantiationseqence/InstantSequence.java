package core.instantiationseqence;

public class InstantSequence {

    class A{
        private String a = "";

        {
            System.out.println("inner parent class, initialisation block" +a/*+b not allowed*/);
        }

        private String b = "";
        A(){
            System.out.println(" inner parent constructor");
        }

    }

    class AA extends A{

        AA(){
            System.out.println(" inner child constructor");
        }

        {
            System.out.println("inner child class, initialisation block after constructor");
        }

    }

    static class StaticInner{
        static{
            System.out.println("Inner static class, static block");
       }
        private static String staticInnerClassVar = "static inner class variable";
    }

    static {
       System.out.println("InstantSequence class, static block");
    }

    {
        System.out.println("InstantSequence class, initialisation block");
    }


    InstantSequence(){
        System.out.println(" InstantSequence class, constructor");
    }

    static void staticMethod(){
        System.out.println(" InstantSequence class, static method");
    }


    public static void main(String[] args) {
        System.out.println("main method, call StaticInner.staticInnerClassVar");
        System.out.println("main method, StaticInner.staticInnerClassVar=" + StaticInner.staticInnerClassVar);
        //AA aa = new AA();illegal, there is no instance of main class yet
        System.out.println("main method, call main class static method");
        staticMethod();
        System.out.println("main method, call main class constructor");
        InstantSequence obj = new InstantSequence();

        System.out.println("main method, call inner child class constructor");
        AA aa = obj.new AA();

        System.out.println("main method, call child class constructor in the same file");
        new BB();

        System.out.println("any class: using (just using not definition)static vars value into static blocks that upper then vars definition is illegal, the same for non-static vars into non-static blocks");
        System.out.println("any class: but using static vars value into non static blocks that upper vars definition is legal");
    }
}

/*can't be public, only class with the same name as file can be pblic*/
class B{
    static {
        System.out.println("parent class in the same file as main, static block");
    }
    {
        System.out.println("parent class in the same file as main, nonstatic block");
    }
    B(){
        System.out.println("parent class in the same file as main, constructor");
    }
}

class BB extends B{
    static {
        System.out.println("child class in the same file as main, static block");
    }
    {
        System.out.println("child class in the same file as main, nonstatic block");
    }
    BB(){
        System.out.println("child class in the same file as main, constructor");
    }
}