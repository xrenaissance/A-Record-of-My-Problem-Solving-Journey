class Solution:
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        bin_counter = 0
        res_arr = []
        if len(nums) == 0:
            return res_arr

        # Init upper limit (exclusive) for binary counter
        bin_max = 2 ** len(nums)

        while bin_counter < bin_max:
            temp_arr = []
            for i in range(len(nums)):
                # Adds elements into temp array
                if (bin_counter >> i) % 2 == 1:
                    temp_arr.append(nums[i])
            res_arr.append(temp_arr)

            # Inrease by 1
            bin_counter += 1

        return res_arr
