class Solution:
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        for aIdx, col in enumerate(A):
            for bIdx, e in enumerate(col):
                # Reverse each cell
                if e == 0:
                    A[aIdx][bIdx] = 1
                else:
                    A[aIdx][bIdx] = 0
            # Flip by reversing the column elements
            A[aIdx] = A[aIdx][::-1]
        return A
