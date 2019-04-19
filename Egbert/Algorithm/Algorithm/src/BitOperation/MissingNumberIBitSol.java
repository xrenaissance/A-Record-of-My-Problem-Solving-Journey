package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * Time: O(N)
 * Space: O(1)
 */
public class MissingNumberIBitSol {
    public int missing(int[] array) {
        if (array == null || array.length == 0) {
            return 1;
        }
        int res = array.length + 1;
        for (int i = 0; i < array.length; i++) {
            res ^= (i + 1);
            res ^= array[i];
        }
        return res;
    }
}
