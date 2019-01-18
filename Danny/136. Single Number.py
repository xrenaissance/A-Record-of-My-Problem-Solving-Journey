class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return nums[0]
        
        num = nums[0]
        for e in nums[1:]:
            num ^= e
        return num
