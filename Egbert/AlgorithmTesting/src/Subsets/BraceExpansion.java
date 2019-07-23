package Subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * @leetcode https://leetcode.com/problems/brace-expansion/
 * @date 23/7/2019
 * @Time max(sublist) ^ size of individual list
 * @Space size of individual list + unique number of Strings
 */
public class BraceExpansion {
    // Solution 1: With List of String and sorting
    public static String[] expand(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sol = new StringBuilder();
        expandDFS(str, 0, sol, result);
        String[] output = new String[result.size()];
        for (int i = 0; i < result.size();i ++) {
            output[i] = result.get(i);
        }
        return output;
    }
    private static void expandDFS(String str, int index,
                                  StringBuilder sol,
                                  List<String> result) {
        if (index == str.length()) {
            if (sol.length() > 0) {
                result.add(sol.toString());
            }
            return;
        }
        int start = sol.length();
        char currChar = str.charAt(index);
        if (currChar == '{') {
            List<Character> subList = new ArrayList<>();
            int endIndex = index + 1;
            while (endIndex < str.length() && str.charAt(endIndex) != '}') {
                if (Character.isLetter(str.charAt(endIndex))) {
                    subList.add(str.charAt(endIndex));
                }
                endIndex++;
            }
            Collections.sort(subList);
            for (Character ch : subList) {
                sol.append(ch);
                expandDFS(str, endIndex + 1, sol, result);
                sol.setLength(start);
            }
        } else {
            // don't need to backtrack, must have
            sol.append(str.charAt(index));
            expandDFS(str, index + 1, sol, result);
        }
    }
    // Solution 2: Using TreeSet
    public static String[] expandTreeSet(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sol = new StringBuilder();
        treeSetDFS(str, 0, sol, result);
        String[] output = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }
    private static void treeSetDFS(String str, int index,
                           StringBuilder sol,
                           List<String> result) {
        if (index == str.length()) {
            if (sol.length() > 0) {
                result.add(sol.toString());
            }
            return;
        }
        int prevPosition = sol.length();
        if (str.charAt(index) == '{') {
            int endIndex = index + 1;
            Set<Character> set = new TreeSet<>();
            while (endIndex < str.length() && str.charAt(endIndex) != '}') {
                if (Character.isLetter(str.charAt(endIndex))) {
                    set.add(str.charAt(endIndex));
                }
                endIndex++;
            }
            for (Character ch : set) {
                sol.append(ch);
                treeSetDFS(str, endIndex + 1, sol, result);
                sol.setLength(prevPosition);
            }
        } else {
            sol.append(str.charAt(index));
            expandDFS(str, index + 1, sol, result);
        }
    }
    public static void main(String[] args) {
        String input2 = "{a,b}c{d,e}feh{h,v,x}{h,b,v,a,e,d,f}yuerarafaf{f,j,a,l,f,j}{c,n,v,b,u,u,1,u,f}";
        long start = System.currentTimeMillis();
        BraceExpansion.expand(input2);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

        start = System.currentTimeMillis();
        BraceExpansion.expandTreeSet(input2);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
