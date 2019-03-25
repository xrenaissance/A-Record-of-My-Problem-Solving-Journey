package GoogleTag;

public class MissingNumberI {
    // using oxr operation to get missing number
    public int missingNumberSolution1(int[] nums) {
        int res = nums.length + 1;
        for (int i = 0; i < nums.length; i++){
            res ^= (i + 1);
            res ^= nums[i];
        }
        return res;
    }

    // using sum difference to get missing number
    public int missingNumberSolution2(int[] nums) {
        int n = array.length + 1;
        int sum = ((1 + n) * n) / 2;
        int sumArray = 0;
        for (int i = 0; i < nums.length; i++) {
            sumArray += nums[i];
        }
        return sum - sumArray;
    }
}
