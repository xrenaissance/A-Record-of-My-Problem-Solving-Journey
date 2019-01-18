class Solution:
    def countPrimeSetBits(self, L, R):
        """
        :type L: int
        :type R: int
        :rtype: int
        """
        def is_prime(num):
            return num in [2,3,5,7,11,13,17,19,23,27,29,31,37,41,43,47]
        total = 0
        for num in range(L, R+1):
            num = bin(num)
            if is_prime(num.count("1")):
                total += 1
        return total
