package CyclicSort;

public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
        if (nums == null || nums.length == 0)  {
            return new int[] { -1, -1 };
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i], i + 1};
            }
        }
        return new int [] {-1, -1};
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
