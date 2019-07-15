package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/reverse-integer/1
 * @date 15/7/2019
 * @Time log N
 * @Space 1
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int digit = 0;
        while (x != 0) {
            digit = x % 10;
            int newResult = result * 10 + digit;
            if ((newResult - digit) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}