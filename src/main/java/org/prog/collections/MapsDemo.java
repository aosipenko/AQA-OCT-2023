package org.prog.collections;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {

    public static void main(String[] args) {
        Map<String, String> sMap = new HashMap<>();
        sMap.put("key_1", "value_1");
        sMap.put("key_2", "value_1");
        sMap.put("key_3", null);
        sMap.put(null, null);

//        System.out.println(sMap.get("key_1"));
//        System.out.println(sMap.get("key_2"));
//        System.out.println(sMap.get("key_3"));
//        System.out.println(sMap.get(null));

//        System.out.println(sMap.containsKey("key_4"));
//        System.out.println(sMap.containsKey("key_2"));
//
//        System.out.println(sMap.get("abc"));

//        System.out.println(sMap.containsValue("value_1"));

        System.out.println(sMap.getOrDefault("key_3", "this is default value"));

        sMap.putIfAbsent("key_1", "new_value");
        System.out.println(sMap.get("key_1"));


    }
}
