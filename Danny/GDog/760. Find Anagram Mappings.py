class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        # Pre-Conditions:
        # A and B will have equal length
        # A and B will always be anagram mappings of each other
        
        # Use a dictionary to map the position of elements in B
        ana_dict = {}
        for idx, val in enumerate(B):
            ana_dict[val] = idx
        
        res = []
        for i in A:
            res.append(ana_dict[i])
        
        return res
