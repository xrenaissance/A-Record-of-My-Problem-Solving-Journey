class Solution:
    def backspaceCompare(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: bool
        """
        def construct(nums):
            """
            :type nums: str
            """
            res = []
            for i in nums:
                if i == "#":
                    if res:
                        res.pop()
                else:
                    res.append(i)
            return res
        return construct(S) == construct(T)
                
