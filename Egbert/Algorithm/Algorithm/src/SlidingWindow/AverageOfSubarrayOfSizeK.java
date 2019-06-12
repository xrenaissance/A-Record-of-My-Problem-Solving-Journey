package SlidingWindow;

public class AverageOfSubarrayOfSizeK {
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
        int[] test = new int[]{1, 3 ,2, 6, -1, 4, 1, 8, 2};
        double[] result = findAverages(5, test);
        System.out.println("Averages of subarrays of size k: " + result.toString());
    }
}
