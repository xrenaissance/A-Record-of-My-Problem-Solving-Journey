class Solution:
    def validUtf8(self, data):
        """
        :type data: List[int]
        :rtype: bool
        """
        i = 0
        while i < len(data):
            # Cannot start with 10
            if data[i] >> 6 == 2:
                return False
            
            # One byte utf-8
            if data[i] >> 7 == 0:
                i += 1
                continue

            # Not a valid utf-8 if there's no 0 in the string
            has_zero = False
            for shift in range(0, 7):
                if (data[i] >> shift) %2 == 0:
                    has_zero = True
                    break
            if not has_zero:
                return False
            
            else:
                # Now the data starts with 1 and will have a ZERO in between
                # Need to extract the number of 1's
                integer = data[i]
                num_ones = 0
                while integer > 0:
                    if integer % 2 == 1:
                        num_ones += 1
                    else:
                        num_ones = 0
                    integer = integer >> 1
                    
                # As it can only be max 4 bytes long, num_ones cannot be over 4
                if num_ones > 4:
                    return False
                
                num_ones -= 1
                # Check for the next $num_ones sequences, they all start with 10 => 2
                # Check if the sequence has ended, which it shouldn't be.
                if (i + num_ones) >= len(data):
                    return False
                
                for j in range(i+1, i+1+num_ones):
                    if data[j] >> 6 != 2:
                        return False

                # Skip the checked data
                i += num_ones + 1
                continue
                       
            i+=1
            
        return True
