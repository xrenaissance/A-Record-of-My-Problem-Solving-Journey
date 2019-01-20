class Solution:
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        if len(S) < 1:
            return [S]
        
        # Construct an array of position of all letters in S
        alp_arr = []
        for idx, e in enumerate(S):
            # a->z: 97->122, A->Z: 65->90
            if ord(e) in range(97, 123) or ord(e) in range(65, 91):
                alp_arr.append(idx)
        
        # Set up a binary counter and its upper boundary exclusive
        bin_counter = 1
        bin_max = 2 ** len(alp_arr)
        
        res_arr = [S]
        
        while bin_counter < bin_max:
            current_counter = bin_counter
            
            # Deep copy a new array
            temp_arr = []
            for i in S:
                temp_arr.append(i)
            
            digit = 0
            # Use bit shift to determine which alphabet needs to be flipped
            while current_counter > 0:
                if current_counter % 2 == 1:
                    # Flip the according index's letter: upper->lower, lower->upper
                    if ord(temp_arr[alp_arr[digit]]) in range(97, 123):
                        temp_arr[alp_arr[digit]] = temp_arr[alp_arr[digit]].upper()
                    else:
                        temp_arr[alp_arr[digit]] = temp_arr[alp_arr[digit]].lower()
                    
                digit += 1
                current_counter >>= 1
            
            res_arr.append("".join(temp_arr))
            
            bin_counter += 1
            
        return res_arr
