package core.overloading;

public class Overloading {
    void method(int i){

    }
    public int method(String s){
        return 0;
    }
    private A method(A a){ return new A();}
    private A method(B b){return new A();}

}
class A{}
class B extends A {}
