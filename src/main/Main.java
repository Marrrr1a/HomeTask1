package main;

import hashmap.CustomHashMap;

public class Main {
    public static void main(String[] args) {
        CustomHashMap <String, Integer> map = new CustomHashMap<>();
        map.put("Aaa",1);
        map.put("Bbb",2);
        map.put("Ccc",3);
        map.put("Aaa",4);
        map.put("Ddd",2);
        System.out.println(map.get("Aaa"));
        System.out.println(map.get("Bbb"));
        System.out.println(map.get("Ccc"));
        System.out.println(map.get("Ddd"));
        System.out.println("HashMap size: " + map.sizeValue());

        map.remove("Ccc");
        System.out.println(map.get("Ccc"));
        System.out.println("HashMap size: " + map.sizeValue());
    }
}
