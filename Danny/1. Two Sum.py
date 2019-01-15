class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        diff_dict = {}
        for idx, num in enumerate(nums):
            if num not in diff_dict:
                diff_dict[target-num] = idx
            else:
                return [idx, diff_dict[num]]
