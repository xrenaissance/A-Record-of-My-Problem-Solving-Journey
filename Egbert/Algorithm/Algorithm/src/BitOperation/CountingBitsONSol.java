package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * If you multiply a number by 2, you are adding a 0 to
 * the end of the binary representation. (ie) 9 = 1001,
 * 18 = 10010. This obviously won't change the number of 1s present.
 * But stop thinking of it in terms of multiplication or division,
 * look at it bitwise. Take some binary number with an unknown
 * number of 1s: ex. 10001110110111. i>>1 trims off the last digit,
 * so we now have 1000111011011. We already solved this number,
 * so we know how many there are in all but the last digit.
 * Now we just have to check whether the last digit is a 1 or not,
 * and we have our answer.
 *
 * Time: O(n)
 * Space: O(1)
 */
public class CountingBitsONSol {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
