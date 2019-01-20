class Solution:
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m == 0 or n == 0:
            return 0

        if m == n:
            return m
        
        # Get first N chars that are the same across the two,
        #   Then pad the number with 0's by bit shifting left
        i = 0
        while m != n:
            m >>= 1
            n >>= 1
            i += 1
        return m << i