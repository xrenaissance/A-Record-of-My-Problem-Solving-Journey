package Math;

/**
 * @leetcode https://leetcode.com/problems/palindrome-number/
 * @date 24/7/2019
 * @Time log x
 * @Space 1
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int original = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == original || x == result/10;
    }
}
