package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * @link https://leetcode.com/problems/reverse-bits/
 * Time: O(N/2)
 * Space: O(1)
 */
public class ReverseBits {
    // 32 bits integer
    public int reverseBits(int n) {
        int left = 31;
        int right = 0;
        while (left > right) {
            n = swapPairOfBits(n, left--, right++);
        }
        return n;
    }
    // any integer in binary representation xor Left1 0000000 Right1
    // will swap the bits
    // get associated bit: move right for position steps
    // then & with 1 = 000000001, if bit is 1 keep same, 0 then 0
    private int swapPairOfBits(int n, int left, int right) {
        int leftBit = (n >> left) & 1; // get left side bit
        int rightBit = (n >> right) & 1; // get the right side bit
        if ((leftBit ^ rightBit) == 1) {
            n ^= ((1 << left) | (1 << right));
        }
        return n;
    }
}
