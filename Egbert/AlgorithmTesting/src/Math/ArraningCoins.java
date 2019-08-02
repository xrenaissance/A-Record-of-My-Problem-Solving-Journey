package Math;

/**
 * @leetcode https://leetcode.com/problems/arranging-coins/
 * @Time 1
 * @Space 1
 */
public class ArraningCoins {
    // x^2 + x - 2n = 0;
    // using long to prevent integer overflow
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
