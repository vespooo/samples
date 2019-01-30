package core;

public class VarArgs {

    void  method1(String... args){

    }

    void  method2(String ...args){

    }

    void  method3(String...args){
    }

    public static void main(String ... args) {
        new VarArgs().method3();
    }
}
