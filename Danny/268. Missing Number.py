class Solution:
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = len(nums)
        i = 0
        print("initial res", res)
        while i < len(nums):
            res ^= i
            res ^= nums[i]
            i += 1
            print(res)
        return res
