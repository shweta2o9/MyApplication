package com.example.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */

public class IntToRoman {
    public String intToRoman(int a) {
        Map<Integer, String> intToRomanMAp = initializeMap();
        int[] bases = { 1000,
                900,
                500,
                400,
                100,
                90,
                50,
                40,
                10,
                9,
                5,
                4,
                1};
        StringBuilder result = new StringBuilder();
        for(int i : bases){
            while(a >= i){
                result.append(intToRomanMAp.get(i));
                a -= i;
            }
        }
        return result.toString();
    }

    private static Map<Integer, String> initializeMap(){
        Map<Integer, String> intToRomanMAp = new HashMap<>();
        intToRomanMAp.put(1, "I");
        intToRomanMAp.put(4, "IV");
        intToRomanMAp.put(5, "V");
        intToRomanMAp.put(9, "IX");
        intToRomanMAp.put(10, "X");
        intToRomanMAp.put(40, "XL");
        intToRomanMAp.put(50, "L");
        intToRomanMAp.put(90, "XC");
        intToRomanMAp.put(100, "C");
        intToRomanMAp.put(400, "CD");
        intToRomanMAp.put(500, "D");
        intToRomanMAp.put(900, "CM");
        intToRomanMAp.put(1000, "M");
        return intToRomanMAp;
    }
}
