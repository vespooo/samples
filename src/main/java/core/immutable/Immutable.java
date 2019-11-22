package core.immutable;

import java.util.ArrayList;
import java.util.List;

public final class Immutable {

    private String str;
    private List<MyType> list;

    public Immutable(String str, List<MyType> list){
        this.str = str;
        this.list = new ArrayList<>();
        copy(list);
    }

    private void copy(List<MyType> list) {
        for (MyType i: list) {
            this.list.add(MyType.copy(i));
        }
    }

    private static class MyType {

        private MyType i;

        public MyType(MyType i) {
            this.i = i;
        }

        public static MyType copy(MyType i) {
            return new MyType(i);
        }
    }

    public String getStr() {
        return str;
    }

    public List<MyType> getList() {
        return list;
    }
}
