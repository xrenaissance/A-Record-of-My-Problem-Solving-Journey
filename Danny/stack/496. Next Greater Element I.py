class Solution:
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # Find the number using a stack
        d = {}
        stack = []
        for i in nums2:
            while len(stack) > 0 and stack[-1] < i:
                # Pop and add to dict
                d[stack.pop()] = i
            stack.append(i)
            
        return [d[i] if i in d else -1 for i in nums1]
