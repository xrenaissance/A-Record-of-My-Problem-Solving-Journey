package String;

/**
 * @leetcode https://leetcode.com/problems/valid-word-abbreviation/
 * @Time N + m
 * @Sapce 1
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        }
        int num = 0;
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                num = num * 10 + abbr.charAt(j) - '0';
                if (num == 0) {
                    return false;
                }
                j++;
            } else {
                i += num;
                if (i >= word.length() || word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                num = 0;
                i++;
                j++;
            }
        }
        return i + num == word.length() && j == abbr.length();
    }
}
