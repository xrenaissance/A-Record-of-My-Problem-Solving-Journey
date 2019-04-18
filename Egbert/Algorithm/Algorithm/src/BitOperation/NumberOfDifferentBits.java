package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * 15 >> 2 = -4   since >> use 0 to fill left
 * -15 >>> = 60   >>> use 1 fill left
 * Time: O(n)
 * Space: O(1)
 */
public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        int count = 0;
        // start from a ^ b, count how many 1 in the bits representation
        for (int i = a ^ b; i != 0; i = i >>> 1) {
            count += (i & 1);
        }
        return count;
    }
}