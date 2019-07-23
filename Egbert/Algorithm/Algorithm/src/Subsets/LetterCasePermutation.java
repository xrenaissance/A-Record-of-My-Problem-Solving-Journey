package Subsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/letter-case-permutation/
 * @date 23/7/2019
 * @Time 2 ^ n
 * @Space n
 */
public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        // StringBuilder currLayer = new StringBuilder();
        char[] currLayer = str.toCharArray();
        permutateHelper(currLayer, 0,  result);
        return result;
    }
    private static void permutateHelper(char[] currLayer, int level,
                                        List<String> result) {
        if (level == currLayer.length) {
            result.add(new String(currLayer));
            return;
        }
        char currChar = currLayer[level];
        if (Character.isDigit(currChar)) {
            permutateHelper(currLayer, level + 1, result);
        } else {
            // add lower case
            currLayer[level] = Character.toLowerCase(currChar);
            permutateHelper(currLayer, level + 1, result);

            // add upper case
            currLayer[level] = Character.toUpperCase(currChar);
            permutateHelper(currLayer, level + 1, result);
        }

    }
    // Solution 2: With StringBuilder
    private static void permutateHelperStringBuilder(String str, int level,
                                                     StringBuilder currLayer,
                                                     List<String> result) {
        if (level == str.length()) {
            result.add(currLayer.toString());
            return;
        }
        char currChar = str.charAt(level);
        if (currChar >= '0' && currChar <= '9') {
            currLayer.append(currChar);
            permutateHelperStringBuilder(str, level + 1, currLayer, result);
            currLayer.deleteCharAt(currLayer.length() - 1);
        } else {
            currLayer.append(Character.toLowerCase(currChar));
            permutateHelperStringBuilder(str, level + 1, currLayer, result);
            currLayer.deleteCharAt(currLayer.length() - 1);

            currLayer.append(Character.toUpperCase(currChar));
            permutateHelperStringBuilder(str, level + 1, currLayer, result);
            currLayer.deleteCharAt(currLayer.length() - 1);
        }
    }
    public static void main(String[] args) {
        char input1 = 'z';
        char input2 = 'G';
        System.out.println(input1 - 'a');
        System.out.println((input2 - 'a') >= 0);
        System.out.println(Character.isAlphabetic('9'));
        String input3 = "a1b2";
        System.out.println(LetterCasePermutation.letterCasePermutation(input3));
        String input4 = "3z4";
        System.out.println(LetterCasePermutation.letterCasePermutation(input4));
        String input5 = "CcC";
        System.out.println(LetterCasePermutation.letterCasePermutation(input5));
    }
}
