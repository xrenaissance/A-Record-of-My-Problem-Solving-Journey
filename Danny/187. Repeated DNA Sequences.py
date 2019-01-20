class Solution:
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def compute_hash(slice):
            '''
            Computes the has for the given array
            :rtype: int
            '''
            return str(slice)

        # Check edge case
        if len(s) < 11:
            return []

        res_arr = []
        seen = {}
        start = 10
        while start < len(s) + 1:
            current_hash = compute_hash(s[start-10:start])
            if current_hash not in seen:
                seen[current_hash] = 1
            else:
                if seen[current_hash] == 1:
                    res_arr.append(s[start-10:start])
                    seen[current_hash] = 2
            start += 1

        return res_arr
