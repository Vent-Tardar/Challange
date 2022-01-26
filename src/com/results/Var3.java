package com.results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Var3 {
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
        Map<String, Integer> finalMap = new HashMap<>();
        GenericInterface genericInterface = n ->
        {
            int i = 0;
            for(String s: n){
                for (String s1: n){
                    if (s.equals(s1)) i++;
                }
                finalMap.put(s, i);
                i=0;
            }
        };
        genericInterface.search(sourceData);
        return finalMap;
    }

    @FunctionalInterface
    interface GenericInterface {
        void search(List<String> data);
    }

}
