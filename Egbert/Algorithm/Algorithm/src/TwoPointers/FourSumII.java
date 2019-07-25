package TwoPointers;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/4sum-ii/
 * @date 26/7/2019
 * @Time N ^ 2
 * @Space N ^ 2 worst
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumRecords = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                sumRecords.put(sum, sumRecords.getOrDefault(sum, 0) + 1);
            }
        }
        int total = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                total += sumRecords.getOrDefault(-sum, 0);
            }
        }
        return total;
    }
}
