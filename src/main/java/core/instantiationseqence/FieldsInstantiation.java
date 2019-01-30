package core.instantiationseqence;

public class FieldsInstantiation {

    protected int a = method();
    int b=1;

    private int method() {
        System.out.println("inside method");
        System.out.println("b=" + b);
        return b+1;
    }


    public FieldsInstantiation() throws Exception{
        System.out.println("inside the constructor");
    }

    public static void main(String[] args) {
        FieldsInstantiation f = null;
        try {
            f = new SubFieldsInstantiation(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(f.a);//a==1
    }
}
