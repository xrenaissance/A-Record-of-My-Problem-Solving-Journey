package BinarySearch;

/**
 * @author Egbert Li
 * @Date 20/03/2019
 * Time Complexity is O(log k), Space Complexity is O(log k)
 */
public class MedianOfTwoSortedArray {
    public double median(int[] a, int[] b) {
        int length = a.length + b.length;
        if (length % 2 == 0) {
            return (kth(a, b, 0, 0, length / 2) + kth(a, b, 0, 0, length / 2 + 1)) / 2.0;
        } else {
            return kth(a, b, 0, 0, length / 2 + 1);
        }
    }
    private double kth(int[] a, int[] b, int startA, int startB, int k) {
        if (startA >= a.length) {
            return b[startB + k - 1];
        }
        if (startB >= b.length) {
            return a[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(a[startA], b[startB]);
        }
        int aHalfK = startA + k / 2 <= a.length ? a[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int bHalfK = startB + k / 2 <= b.length ? b[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (aHalfK < bHalfK) {
            return kth(a, b, startA + k / 2, startB, k - k / 2);
        } else {
            return kth(a, b, startA, startB + k / 2, k - k / 2);
        }
    }
}
