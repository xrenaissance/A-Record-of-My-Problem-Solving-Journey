package Math;

/**
 * @leetcode https://leetcode.com/problems/count-primes/
 * @date 29/7/2019
 * @Time 2 * N
 * @Space N
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int total = 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                total++;
            }
        }
        return total;
    }
}
