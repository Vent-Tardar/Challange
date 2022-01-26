package com.results;

import java.util.*;

public class Var2 {

    public static void main(String[] args) {
        int listSize = 10_000;
        List<String> sourceData = new ArrayList<>(listSize);
        for (int i=0; i<listSize; i++) {
            sourceData.add(""
                    +(char)('A'+(char)(Math.random()*('Z'-'A'+1)))
                    +(char)('A'+(char)(Math.random()*('Z'-'A'+1)))
                    +(char)('A'+(char)(Math.random()*('Z'-'A'+1))));
        }

        long startTime = System.nanoTime();
        count(sourceData);
        long endTime = System.nanoTime();
        System.out.println("result for Map: " + ((endTime - startTime)/1000000.0) + " ms.");
    }

    private static Map<String, Integer> count(List<String> sourceData) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: sourceData){
            int i = Collections.frequency(sourceData, s);
            map.put(s, i);
        }
        return map;
    }

}
