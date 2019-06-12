package SlidingWindow;
import java.util.Arrays;
public class AverageOfSubarrayOfSizeK {
    // Time: O(n * k)
    // Space: O(n - k + 1)
    public static double[] findAveragesDumb(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        for (int i = 0; i <= arr.length - K; i++) {
            // find sum of next 'K' elements
            double sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += arr[j];
            }
            result[i] = sum / K; // calculate average
        }
        return result;
    }

    public static double[] findAverages(int K, int[] array) {
        if (array == null || array.length == 0 || K < 0) {
            return new double[0];
        }
        double[] result = new double[array.length - K + 1];
        int windowStart = 0;
        double windowSum = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            windowSum += array[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required
            // window size of 'k'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= array[windowStart]; // subtract the element going out
                windowStart++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
