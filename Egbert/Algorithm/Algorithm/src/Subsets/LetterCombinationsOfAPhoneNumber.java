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
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sol = new StringBuilder();
        combinDFS(digits, 0, sol, map, result);
        return result;
    }
    private static void combinDFS(String digits, int index,
                                  StringBuilder sol,
                                  String[] map,
                                  List<String> result) {
        if (index == digits.length()) {
            if (sol.length() > 0) {
                result.add(sol.toString());
            }
            return;
        }
        String letters =  map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sol.append(letters.charAt(i));
            combinDFS(digits, index + 1, sol, map, result);
            sol.deleteCharAt(sol.length() - 1);
        }
    }
    public static void main(String[] args) {
        String input1 = "23";
        System.out.println(LetterCombinationsOfAPhoneNumber.letterCombinations(input1));
    }
}
