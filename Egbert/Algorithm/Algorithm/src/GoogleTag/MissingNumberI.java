package GoogleTag;

public class MissingNumberI {
    public int missingNumberSolution1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
