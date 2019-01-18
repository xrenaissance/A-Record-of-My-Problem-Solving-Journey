class Solution:
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n==0:
            return False
        n = bin(n)
        return False if n.count("00")+n.count("11") > 0 else True
