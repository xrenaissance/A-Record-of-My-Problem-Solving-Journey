class Solution:
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        # May contain duplicates
        # len(A|B) = [1, 100]
        # Integers are [0, 10^5]
        
        # Naive approach: brute force each elements in A and B
        #   - Loop through each element of A, then loop in B to find its location
        #   - Time Complexity: O(N^2)
        
        # Alternatively, construct a dictionary in which its keys are the values of B's elements and its values are indexes of the element accordingly. Max size = 10^5
        # Time Complexity: O(2N)
        # As duplicates are okay to output any, it should be fine
        mapper_dict = {}
        for idx, val in enumerate(B):
            mapper_dict[val] = idx
        
        result_list = []
        for e in A:
            result_list.append(mapper_dict[e])
            
        return result_list