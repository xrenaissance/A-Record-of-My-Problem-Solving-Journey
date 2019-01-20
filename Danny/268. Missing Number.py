class Solution:
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums) == 1:
            if 1 not in nums:
                return 1
        
        # Sort O(NlogN)
        sorted_nums = sorted(nums)
        
        if sorted_nums[0] != 0:
            return 0
        
        i = 0
        while i < len(sorted_nums)-1:
            #print(i)
            if i + 1 != sorted_nums[i+1]:
                break
            i += 1
        return i + 1
