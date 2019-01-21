class Solution:
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "0"
        if num < 0:
            # Negative case
            num = 2 ** 32 + num
            
        print(num)
        return hex(num)[2:]
