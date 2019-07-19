package TwoPointers;

/**
 * @date 20/7/2019
 * @leetcode https://leetcode.com/problems/squares-of-a-sorted-array/
 * @Time  N
 * Space O N if result array is counted
 */
public class SquareSum {
    public static long[] squareSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new long[0];
        }
        long[] result = new long[arr.length];
        int left = 0;
        int right = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Math.abs(arr[left]) >= Math.abs(arr[right])) {
                result[i] = arr[left] * arr[left];
                left++;
            } else {
                result[i] = arr[right] * arr[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = new int[] {-6, -3, -1, 2, 4, 5};
        int[] input2 = new int[] {-5, -4, -2, 0, 1};
        long[] result1 = TopKElements.SquareSum.squareSort(input1);
        long[] result2 = TopKElements.SquareSum.squareSort(input2);
        for(int i = 0; i < result1.length; i++) System.out.print(result1[i] + " ");
        System.out.println();
        for(int i = 0; i < result2.length; i++) System.out.print(result2[i] + " ");
    }
}
