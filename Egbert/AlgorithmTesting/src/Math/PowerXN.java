package Math;

/**
 * @leetcode https://leetcode.com/problems/powx-n/
 * @date 28/7/2019
 * @Time log N
 * @Sapce 1
 */
public class PowerXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n/2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2) * x;
        }
    }
    public static void main(String[] args) {
        System.out.println((-3) / 2);
    }
}
