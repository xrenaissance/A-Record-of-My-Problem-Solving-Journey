package main.onlinejudges.leetcode.week1;

class TwoSumBruteFroce {
    public static int[] twoSum(int[] nums, int target) {

        for(int i=0; i < nums.length - 1; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] {i, j};

            }
        }

        return null;
    }

    public static void main(String args[]) {
        int [] answer = twoSum(new int[] {2,7,11,15}, 9);
        System.out.println(answer[0] + " " + answer[1]);
    }
}