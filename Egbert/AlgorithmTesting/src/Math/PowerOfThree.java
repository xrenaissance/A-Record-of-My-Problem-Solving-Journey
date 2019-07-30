package Math;

/**
 * @leetcode https://leetcode.com/problems/power-of-three/
 * @Time log N
 * @Space 1
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
    // Solution 2
    // 3 ^ n = Integer.MAX_VALUE n = log(max)/log(3)
    public boolean isPowerOfThreeLog(int n) {
        int maxNum = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3)));
        return (n > 0 && maxNum % n == 0);
    }
}
