package String;
import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/valid-word-square/
 * @Time m * n
 * @Space m * n
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();
        int cols = words.get(0).length();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!word.equals(getVerticalString(words, i))) {
                return false;
            }
        }
        return true;
    }
    private String getVerticalString(List<String> words, int col) {
        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (col < word.length()) {
                sol.append(word.charAt(col));
            }
        }
        return sol.toString();
    }
}

