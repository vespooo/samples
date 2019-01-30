package core;

public class PassingParameters {
    public static void main(String[] args) {
        int k = 0;
        System.out.println("before method run k="+k);
        method(k);
        System.out.println("after method run k="+k);

        Integer n = 0;
        System.out.println("before method run n="+n);
        method(n);
        System.out.println("after method run n="+n);

        A a = new A();
        System.out.println("before method run a.i="+a.i);
        new PassingParameters().method(a);
        System.out.println("after method run a.i="+a.i);
    }

    private static void method(Integer k) {
        k++;//because it's k=k+1 it's reassigning the k ref to k+1 ref, but not changing k
    }

    private void method(A a) {
        a.change();
    }
}
class A{
    int i;
    void change(){
        i++;
    }
}
