package org.prog.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> sSet = new HashSet<>();

        sSet.add("a");
        sSet.add("a");
        sSet.add("a");
        sSet.add("a");
        sSet.add("a");
        sSet.add("a");
        sSet.add("b");

        System.out.println(sSet.size());
    }
}
