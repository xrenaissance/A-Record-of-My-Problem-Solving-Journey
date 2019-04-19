package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 */
public class BitWiseANDofNumbers {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }
}
