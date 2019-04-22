package DP;

public class MaxProductOfCuttingRope {










    // 左大段，右大段
    // m[i] = {i, j, 0 <= j < i <= n | max(j, m[j]) * max(i - j, m[i - j]))
    // Time: O(N ^ 2)
    // Space: O(N)
    public int maxProductSol1(int length) {
        // records[i] = max()
        // 0 1 2 3 4 5 6 7 8 9 10
        int[] records = new int[length + 1];
        records[1] = 1;
        records[2] = 1;
        for (int i = 3; i < records.length; i++) {
            int currMax = 0;
            // at least one of the partitions after cutting is <= i/2
            // so we can just pick that partition, and find the maximum product
            for (int j = 1; j <= i / 2; j++) {
                // for the other partitions, we can choose not cutting it or
                // cutting it, so the max number we can get is either i -j or array[i - j]
                currMax = Math.max(currMax, Math.max(j, records[j]) * Math.max(i - j, records[i - j]));
            }
            records[i] = currMax;
        }
        return records[length];
    }
}
