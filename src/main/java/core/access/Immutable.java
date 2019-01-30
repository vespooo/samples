package core.access;

public class Immutable {

    public static void main(String[] args) {
        AAA a = new AAA();
        a.list.add("sfs");
        System.out.println(a.list);
    }
}
