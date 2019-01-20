class Solution:
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if len(s) == 1:
            for i in t:
                if i != s:
                    return i
        
        res = 0
        i = 0
        while i < len(s):
            print(i)
            # length of t is always s + 1
            res ^= ord(s[i]) ^ ord(t[i])
            i += 1
        return chr(res ^ ord(t[i]))
            
