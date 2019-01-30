package core.access;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AAA {
    final List<String> list;

    public AAA() {
        list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(new Integer(1));
        set.add(new Integer(1));
        System.out.println(set.size());

    }

    public static void main(String[] args) {
        new AAA();
    }
}
