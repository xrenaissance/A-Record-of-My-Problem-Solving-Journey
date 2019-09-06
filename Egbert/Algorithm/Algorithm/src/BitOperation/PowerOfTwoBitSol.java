package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * 2 ^ n can be expressed like 0000 0100 0000
 * 2 ^ n - 1 will be           0000 0010 0000
 * so number & (number - 1) will be 0 for sure
 * Time: O(1)
 * Space: O(1)
 */
public class PowerOfTwoBitSol {
    public boolean isPowerOfTwo(int number) {
        if (number < 1) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }
}
