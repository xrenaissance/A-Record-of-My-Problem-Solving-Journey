class Solution:
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """
        return int(bin(num).replace("0","x").replace("1","0").replace("x","1").replace("1b",""), 2)
