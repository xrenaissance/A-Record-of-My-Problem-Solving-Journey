package Math;

/**
 * @leetcdoe https://leetcode.com/problems/string-to-integer-atoi/
 * @Time n
 * @Space 1
 *
 * This question is same as valid number, binary representation
 * just using index to ieterate the string.
 */
public class ATOI {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int index = 0;
        int sign = 1;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        if (index >= str.length()) {
            return 0;
        }
        if (!Character.isDigit(str.charAt(index))) {
            return 0;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (!Character.isDigit(str.charAt(index))) {
                break;
            }
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE) {
                break;
            }
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
}
