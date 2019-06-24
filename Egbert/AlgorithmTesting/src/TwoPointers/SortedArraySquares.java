package TwoPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/4873047792156672
 * @author Egbert Li
 * @date 23/06/2019
 * @Time O(n)
 * @Space O 1
 */
public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        if (arr == null || arr.length == 0) {
            return squares;
        }
        int highestSquareIndex = arr.length - 1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int startSquare = arr[start] * arr[start];
            int endSquare = arr[end] * arr[end];
            if (startSquare >= endSquare) {
                squares[highestSquareIndex--] = startSquare;
                start++;
            } else {
               squares[highestSquareIndex--] = endSquare;
               end--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}