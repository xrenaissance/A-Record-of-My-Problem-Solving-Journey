package main.onlinejudges.leetcode.week1;

import java.util.HashMap;

class TwoSumHashTableSingleLoop {
    public static int[] twoSum(int[] nums, int target) {

        // Hash
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < nums.length ; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && i != index) {
                return new int[] {i, index};
            }

            map.put(nums[i], i);
        }

        return null;
    }
    public static void main(String args[]) {
        int [] answer = twoSum(new int[] {2,7,11,15}, 9);
        System.out.println(answer[0] + " " + answer[1]);
    }
}