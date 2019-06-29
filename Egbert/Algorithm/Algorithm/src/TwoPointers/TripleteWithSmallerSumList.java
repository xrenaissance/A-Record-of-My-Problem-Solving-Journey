package TwoPointers;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5554621957275648
 * @author Egbert Li
 * @date 28/06/2019
 * @Time  N log N +  N ^ 3
 * @Spce O N quick sort requires O N space
 */
public class TripleteWithSmallerSumList {
    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return triplets;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            searchPairs(arr, i + 1, arr[i], target - arr[i], triplets);
        }
        return triplets;
    }

    // O N ^ 2
    private static void searchPairs(int[] arr, int left,
                                    int currNum, int target,
                                    List<List<Integer>> triplets) {
        int right = arr.length - 1;
        // O N
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                int tempRright = right;
                // O N
                while (left < tempRright) {
                    triplets.add(Arrays.asList(currNum, arr[left], arr[tempRright]));
                    tempRright--;
                }
                left++;
            } else {
                right--;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(TripleteWithSmallerSumList.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripleteWithSmallerSumList.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
