package BitOperation;

/**
 * @leetcode https://leetcode.com/problems/number-of-1-bits/
 * @date 30/7/2019
 * @Time log N
 * @Sapce 1
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    //  bit shifting unsigned operation >>> (while >> depends on sign extension)
    public int hammingWeight(int n) {
        int total = 0;
        while (n != 0) {
            total += (1 & n);
            n = (n >>> 1);
        }
        return total;
    }
}
