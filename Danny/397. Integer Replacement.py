class Solution:
    def integerReplacement(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 0
        if n % 2:
            return 1 + min(self.integerReplacement(n-1), self.integerReplacement(n+1))
        else:
            return 1 + self.integerReplacement(n/2)
