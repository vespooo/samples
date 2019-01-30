package core;

public class CovariantTypes {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb.method());
    }
}

class B{

    Object method(){
        return new Object();
    }
}
class BB extends B{

    @Override
    String method(){
        return "new type in the same derection of inhereat classes";
    }
}
