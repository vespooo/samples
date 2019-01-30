package core;

public class References {
    private Object a;
    private Object b;
    private Object c;

    public void setA(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public void setB(Object b) {
        this.b = b;
    }

    public Object getB() {
        return b;
    }

    public void assign() {
        a=b;
        b=c;
    }

    public void setC(Object c) {
        this.c = c;
    }
}
