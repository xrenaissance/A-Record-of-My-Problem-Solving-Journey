package Math;

/**
 * @leetcode https://leetcode.com/problems/add-digits/
 * @Time log n
 * @Space 1
 */
public class AddDigits {
    // 10 ^ k % 9 = 1
    // a10^k + b10^k-1 + c10^k-2 + d10^k-3 +e   % 9
    // = (a + b + c + d + e) % 9
    public int addDigitsMath(int num) {
        if (num < 10) {
            return num;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }
    public int addDigits(int num) {
        int digit = 0;
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
