package CyclicSort;

/**
 * @leetcode
 * @Time N
 * @Space 1
 */
public class CyclicSort {
    public static void sort(int[] nums) {
        if ( nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        while (index < nums.length) {
            int j = nums[index] - 1;
            if (nums[index] != nums[j]) {
                swap(nums, index, j);
            } else {
                index++;
            }
        }
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
