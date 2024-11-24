package com.example.demoaiprogrammer.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String word1 = "ac";
        String word2 = "bb";

        System.out.println(isAnagram(word1, word2));
    }
    public static boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        String sortedSCharArray = Arrays.toString(sCharArray);

        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);
        String sortedTCharArray = Arrays.toString(tCharArray);
        
        return sortedSCharArray.equals(sortedTCharArray);
    }

}
