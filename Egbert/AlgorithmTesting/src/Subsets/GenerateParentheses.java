package Subsets;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/generate-parentheses/
 * @date 22/7/2019
 * @Time 2 ^ n
 * @Space n
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        StringBuilder currLayer = new StringBuilder();
        generate(n, currLayer, 0, 0, result);
        return result;
    }
    private static void generate(int n, StringBuilder currLayer, int left,
                          int right, List<String> result) {
        if (right == n) {
            result.add(currLayer.toString());
            return;
        }
        if (left < n) {
            currLayer.append('(');
            generate(n, currLayer, left + 1, right, result);
            currLayer.deleteCharAt(currLayer.length() - 1);
        }
        if (left > right && right < n) {
            currLayer.append(')');
            generate(n, currLayer, left, right + 1, result);
            currLayer.deleteCharAt(currLayer.length() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(GenerateParentheses.generateParenthesis(2));
        System.out.println(GenerateParentheses.generateParenthesis(3));
    }
}
