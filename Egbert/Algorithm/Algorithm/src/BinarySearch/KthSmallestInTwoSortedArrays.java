package BinarySearch;
/**
 * @author Egbert Li
 * @Date 20/03/2019
 * Time Complexity is O (log k), Best Case O(1), Space Complexity O(log k),
 */
public class KthSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b, int k) {
        return kth(a, b, 0, 0, k);
    }

    private int kth(int[] a, int[] b, int startA, int startB, int k) {
        // a doest not have enough elements
        if (startA >= a.length) {
            return b[startB + k - 1];
        }

        // b does not have enough elements
        if (startB >= b.length) {
            return a[startA + k - 1];
        }

        // extreme case first smallest
        if (k == 1) {
            return Math.min(a[startA], b[startB]);
        }

        // default value, if a or b doest not have enough k/2 elements anymore
        int aHalfK = Integer.MAX_VALUE, bHalfK = Integer.MAX_VALUE;
        if (startA + k / 2 <= a.length) {
            aHalfK = a[startA + k / 2 - 1];
        }
        if (startB + k / 2 <= b.length) {
            bHalfK = b[startB + k / 2 - 1];
        }

        // Finding the rest k - k / 2 elements
        if (aHalfK < bHalfK) {
            return kth(a, b, startA + k / 2, startB, k - k / 2);
        } else {
            return kth(a, b, startA, startB + k / 2, k - k / 2);
        }
    }
}
