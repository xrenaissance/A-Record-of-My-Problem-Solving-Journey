package Math;

/**
 * @leetcode https://leetcode.com/problems/power-of-four/
 * @Time 1 or log n
 * @Space 1
 */
public class PowerOfFour {
    //4^x-1=(2^x-1)(2^x+1). And 2^x mod 3 is not 0. So either 2^x-1 or 2^x +1 must be 0.
    public boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
    // Naive solution
    public boolean isPowerOfFourLog(int n) {
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return n == 1;
    }
}
