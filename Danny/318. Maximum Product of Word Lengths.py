class Solution:
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        def check_pair(word_a, word_b):
            '''
            :type word_a, word_b: str
            rtype: Boolean
            ''' 
            seen = {}
            for letter in word_a:
                if letter not in seen:
                    seen[letter] = 0
            for letter in word_b:
                if letter in seen:
                    return False
            return True
        
        # Edge Case
        if len(words) == 1:
            return 0
        
        pair_arr = []
        
        # Permutate: List[[score, wordA, wordB]]
        for idx, i in enumerate(words):
            for j in words[idx+1:]:
                pair_arr.append([len(i) * len(j), i, j])
        
        # Sort the permutation based on multiplication score
        pair_arr = sorted(pair_arr, key=lambda x: x[0], reverse=True)
        
        #print(pair_arr)
        
        for each_pair in pair_arr:
            if check_pair(each_pair[1], each_pair[2]):
                print(each_pair)
                return each_pair[0]
        return 0
            
