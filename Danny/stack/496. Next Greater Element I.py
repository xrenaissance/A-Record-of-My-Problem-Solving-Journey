class Solution:
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        def find_next_greater_element(nums, val):
            '''
            :type nums List[int]
            :rtype: int
            
            Finds the next greater element within the given list
            '''
            for i in nums:
                if i > val:
                    return i
            return None
        
        # Construct a dict {value: next greater value}
        rel_dict = {}
        for idx, val in enumerate(nums2):
            rel_dict[val] = find_next_greater_element(nums2[idx:], val)
        
        res_list = []
        for i in nums1:
            res = rel_dict[i]
            res_list.append(res if res else -1)
        
        return res_list
