package Subsets;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @leetcode https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @date 23/7/2019
 * @Time 3 ^ (length of digits)
 * @Space length of digits
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Character>> map = new HashMap<>();
        char endChar = 'a';
        for (int i = 2; i <= 9; i++) {
            List<Character> value = new ArrayList<>();
            int end = 3;
            if (i == 7 || i == 9) {
                end = 4;
            }
            for (int j = 0; j < end; j++) {
                value.add(endChar);
                endChar = (char) (endChar + 1);
            }
            char key = (char) ('0' + i);
            map.put(key, value);
        }
        for (Map.Entry<Character, List<Character>> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " " + entry.getValue().toString());
        }
        StringBuilder sol = new StringBuilder();
        combinDFS(digits, 0, sol, map, result);
        return result;
    }
    private static void combinDFS(String digits, int index,
                                  StringBuilder sol,
                                  Map<Character, List<Character>> map,
                                  List<String> result) {
        if (index == digits.length()) {
            if (sol.length() > 0) {
                result.add(sol.toString());
            }
            return;
        }
        for (Character ch : map.get(digits.charAt(index))) {
            sol.append(ch);
            combinDFS(digits, index + 1, sol, map, result);
            sol.deleteCharAt(sol.length() - 1);
        }
    }
    public static void main(String[] args) {
        String input1 = "23";
        System.out.println(LetterCombinationsOfAPhoneNumber.letterCombinations(input1));
    }
}
