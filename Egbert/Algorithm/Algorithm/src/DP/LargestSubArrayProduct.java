package DP;

/**
 * @author Egbert Li
 * @date 28/04/2019
 * Time: O(N)
 * Space: O(1)
 */
public class LargestSubArrayProduct {
    // max[i] represents maximum product until ith index subarray
    // min[i] represents minimum product until ith index subarray
    // max[j] = max {array[j] * max[j - 1], array[j] * max[j - 1], array[j]}
    // min[j] = min(array[j] * min[j - 1], array[j] * min[j - 1], array[j])
    // result = max(result, max[j]);
    public double largestProduct(double[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        double min = array[0];
        double max = array[0];
        double result = array[0];
        for (int i = 1; i < array.length; i++) {
            double prevMin = min;
            double prevMax = max;
            min = Math.min(array[i] * prevMin, array[i] * prevMax);
            min = Math.min(min, array[i]); // if array[i] is smaller than either of above, reset value to array[i]
            max = Math.max(array[i] * prevMin, array[i] * prevMax);
            max = Math.max(max, array[i]); // same as min, reset curr max to array[i]
            result = Math.max(result, max); // keep tracking the global max
        }
        return result;
    }
}
