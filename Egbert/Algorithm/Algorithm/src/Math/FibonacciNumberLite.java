package Math;

/**
 * @author Egbert Li
 * @date 10/06/2019
 * @Time O(K)
 * @Space O(1)
 */
public class FibonacciNumberLite {
    public int fibonacci(int K) {
        if (K <= 0) {
            return 0;
        } else if (K <= 1) {
            return 1;
        }
        return fibonacci(K, 0, 1);
    }
    private int fibonacci(int k, int prePrev, int prev) {
        for (int i = 2; i < k; i++) {
            int temp = prev;
            prev += prePrev;
            prePrev = temp;
        }
        return prePrev + prev;
    }
}
