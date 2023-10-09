package org.prog.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListsDemo {

    public static void main(String[] args) {
        List<String> bList = new ArrayList<>();
        List<String> aList = new ArrayList<>();

        aList.add("a");
        aList.add("b");
        bList.add("c");
        bList.add("d");

//        System.out.println(aList.size());
        aList.addAll(bList);
//        System.out.println(aList.size());

        System.out.println("============FOR_I==============");
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("============FOR==============");

        for (String s : aList) {
            System.out.println(s);
        }

        System.out.println("==========ITERATOR================");

        Iterator<String> iString = aList.iterator();
        while (iString.hasNext()) {
            System.out.println(iString.next());
        }
        //<<<<<<
        //0 - a <<<<<
        //1 - b <<<<<
        //2 - c <<<<<
        //3 - d <<<<<
        //end
        System.out.println("=============STREAM=============");

        aList.stream().forEach(s -> {
            System.out.println(s);
        });

//        aList.add("aaa");//0
//        aList.add("aaa");//0
//        aList.add("aaa");//0
//        aList.add("aaa");//0
//        aList.add("aaa");//0
//        aList.add("aaa");//0
//        aList.add("bbbb");//1
//        aList.add("ddd");//2
//        aList.add("e");//3
//        aList.add("fffff");//4
//
//        bList.add("aaa");
//        bList.add("bbbb");
//        bList.add("e");
//
//        System.out.println(aList.size());

//        System.out.println(aList.get(0));
//        System.out.println(aList.contains("e"));
//        System.out.println(aList.indexOf("ddd"));
//        System.out.println(aList.get(aList.indexOf("bbbb")));

//        System.out.println(aList.size());
//        System.out.println(aList.contains("aaa"));
//        aList.removeAll(bList);
//        aList.remove("aaa");
//        aList.remove(1);
//        System.out.println(aList.size());
//        System.out.println(aList.contains("aaa"));


    }
}
