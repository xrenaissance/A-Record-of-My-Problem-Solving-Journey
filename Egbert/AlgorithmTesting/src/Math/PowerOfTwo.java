package Math;

/**
 * @leetcode https://leetcode.com/problems/power-of-two/
 * @Time 1
 * @Space 1
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
