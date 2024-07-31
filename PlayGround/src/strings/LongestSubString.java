package strings;

// Java program to find longest common prefix of
// given array of words.

import java.util.*;

public class LongestSubString {
    public String longestCommonPrefix(String[] arr) {
        int n = arr.length;
        String result = arr[0];

        for (int i = 1; i < n; i++) {
            while (arr[i].indexOf(result) != 0) {

                result = result.substring(0, result.length() - 1);

                if (result.isEmpty()) {
                    return "-1";
                }
            }
        }

        return result;
    }

    /* Driver Function to test other function */
    public static void main(String[] args) {
        LongestSubString gfg = new LongestSubString();
        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("The longest Common Prefix is : " +
                gfg.longestCommonPrefix(input));
    }
}
