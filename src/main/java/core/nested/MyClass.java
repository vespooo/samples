package core.nested;

public class MyClass {
    public int publicVar;
    protected int protectedVar;
    private int privateVar;

    public static int publicStaticVar;
    protected static int protectedStaticVar;
    private static int privateStaticVar;

    private void testAccess(){
        //not ok, there is no instance
//        publicVarNested=1;
//        protectedVarNested=1;
//        privateVarNested=1;
//
//        publicStaticVarNested=1;
//        protectedStaticVarNested=1;
//        privateStaticVarNested=1;
//
//        publicVarInner;
//        protectedVarInner;
//        privateVarInner;

        Nested nested = new Nested();
        nested.publicVarNested=1;
        nested.protectedVarNested=1;
        nested.privateVarNested=1;

        nested.publicStaticVarNested=1;
        nested.protectedStaticVarNested=1;
        nested.privateStaticVarNested=1;

        Inner inner = new Inner();
        inner.publicVarInner =1;
        inner.protectedVarInner = 1;
        inner.privateVarInner = 1;
    }
    private static class Nested{
        public int publicVarNested;
        protected int protectedVarNested;
        private int privateVarNested;

        public static int publicStaticVarNested;
        protected static int protectedStaticVarNested;
        private static int privateStaticVarNested;

        private void testAccess(){
            //publicVar not ok because not static
            //protectedVar not ok
            //privateVar not ok

            publicStaticVar=1;
            protectedStaticVar =1;
            privateStaticVar = 1;
        }
    }

    private class Inner{
        public int publicVarInner;
        protected int protectedVarInner;
        private int privateVarInner;

        //public static int publicStaticVarNested; not ok because Inner is not static
        //protected static int protectedStaticVarNested;
        //private static int privateStaticVarNested;

        private void testAccess(){
            publicVar = 1;
            protectedVar = 1;
            privateVar = 1;

            publicStaticVar=1;
            protectedStaticVar =1;
            privateStaticVar = 1;
        }
    }
}


