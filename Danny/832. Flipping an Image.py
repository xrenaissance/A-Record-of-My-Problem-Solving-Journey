class Solution:
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        for col in A:
            for idx in range((len(col) + 1) // 2):
                col[idx], col[~idx] = col[~idx] ^ 1, col[idx] ^ 1
        return A
