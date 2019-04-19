package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * Time: O(number * 32)
 * Space: O(1)
 */
public class CountingBitsMNSol {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int i = 0;
        while (i <= num) {
            result[i] = counting(i);
            i++;
        }
        return result;
    }
    private int counting(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>>= 1;
        }
        return count;
    }
}
