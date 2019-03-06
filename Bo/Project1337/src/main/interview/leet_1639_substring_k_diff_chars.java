package main.interview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class leet_1639_substring_k_diff_chars {
    public static void main(String[] args) {
        int result;
        result = solution_basic("CCAAAAAABBCDEF", 3);
        System.out.println("result 1 = " + result);
        result = solution_optimised("CCAAAAAABBCDEF", 3);
        System.out.println("result 2 = " + result);
    }

    public static int solution_basic(String stringIn, int K) {
        Set<String> set = new LinkedHashSet<>();
        Set<Character> charSet = new HashSet<>();
        int j = 0;
        int len = stringIn.length();
        int count = 0;  // For benchmarking

        // loop whole string - Pointer 1
        for (int i = 0; i <= len - K; i++) {
//            System.out.println("in ij = " + i + j);   // loop details
            count ++;   // For benchmarking

            // check substring with length k
            while (j < len && charSet.size() < K) {
                char c = stringIn.charAt(j);

                // repeat char found
                if (charSet.contains(c)) {
                    // TODO Can be optimised by popping out all chars up to the repeated char
                    break;
                }

                // no repeat char yet
                charSet.add(c);
                j++;

                // no repeat char until record result reached
                if (charSet.size() == K) {
                    set.add(stringIn.substring(i, j));
                }
            }
            // remove first char
            charSet.remove(stringIn.charAt(i));

        }
        System.out.println("count = " + count);  // For benchmarking
        return set.size();
    }

    public static int solution_optimised(String stringIn, int k) {
        Set<String> set = new LinkedHashSet<>();
        Set<Character> charSet = new HashSet<>();
        int j = 0;
        int len = stringIn.length();
        int count = 0;  // benchmark

        // loop whole string - Pointer 1
        for (int i = 0; i <= len - k; i++) {
//            System.out.println("in ij = " + i + j);   // loop details
            count ++;   // benchmark
            // check substring with length k
            while (j < len && j - i < k) {
                char c = stringIn.charAt(j);

                // repeat char found
                if (charSet.contains(c)) {
                    // Optimised by popping out all chars up to the repeted char
                    boolean foundReapeatedChar = false;
                    i--;
                    char removed;
                    do {
                        removed = stringIn.charAt(++i);
                        charSet.remove(removed);
                    } while(removed != c && !charSet.isEmpty());
                    break;
                }

                // no repeat char yet
                charSet.add(c);
                j++;

                // no repeat char until record result reached
                if (charSet.size() == k) {
                    set.add(stringIn.substring(i, j));
                    charSet.remove(stringIn.charAt(i));
                }
            }
        }

        System.out.println("count = " + count);     // benchmark
        return set.size();
    }
}
