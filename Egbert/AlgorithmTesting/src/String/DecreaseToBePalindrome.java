package String;

/**
 * https://www.lintcode.com/problem/decrease-to-be-palindrome/description?_from=ladder&&fromId=14
 * @Time N
 * @Space 1
 */
public class DecreaseToBePalindrome {
    /**
     * @param s: the string s
     * @return: the number of operations at least
     */
    public int numberOfOperations(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int total = 0;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            total += Math.abs(s.charAt(left++) - s.charAt(right--));
        }
        return total;
    }
}
