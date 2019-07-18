package TopKElements;

/**
 * @date 17/7/2019
 * @Time log N + N
 * Space O N if result array is counted
 */
public class SquareSum {
    public static long[] squareSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new long[0];
        }
        int index = largetstSmallerZero(arr);
        int left = Math.max(0, index);
        int right = Math.min(index + 1, arr.length - 1);
        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (left >= 0 && right < arr.length) {
                long leftSquare = arr[left] * arr[left];
                long rightSquare = arr[right] * arr[right];
                if (leftSquare <= rightSquare) {
                    result[i] = leftSquare;
                    left--;
                } else {
                    result[i] = rightSquare;
                    right++;
                }
            } else if (right < arr.length) {
                result[i] = arr[right] * arr[right];
                right++;
            } else if (left >= 0) {
                result[i] = arr[left] * arr[left];
                left--;
            }
        }
        return result;
    }
    private static int largetstSmallerZero(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == 0) {
                return mid;
            } else if (arr[mid] > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start > 0 ? start - 1 : start;
    }
    public static void main(String[] args) {
        int[] input1 = new int[] {-6, -3, -1, 2, 4, 5};
        int[] input2 = new int[] {-5, -4, -2, 0, 1};
        long[] result1 = SquareSum.squareSort(input1);
        long[] result2 = SquareSum.squareSort(input2);
        for(int i = 0; i < result1.length; i++) System.out.print(result1[i] + " ");
        System.out.println();
        for(int i = 0; i < result2.length; i++) System.out.print(result2[i] + " ");
    }
}
