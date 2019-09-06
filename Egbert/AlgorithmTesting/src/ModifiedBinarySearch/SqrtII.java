package ModifiedBinarySearch;

/**
 * @leetcode https://www.lintcode.com/problem/sqrtx-ii/description?_from=ladder&&fromId=14
 * @Time log N
 * @Space 1
 */
public class SqrtII {
    // solution 1: binary search
    public double sqrtbs(double x) {
        double start = 0.0;
        double end = Math.max(1, x);
        while (start + 1e-12 < end) {
            double mid = start + (end - start) / 2;
            if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }

    // Solution2 : Neton method
    public double sqrt(double x) {
        double res = 1.0;
        while (Math.abs(res * res - x) > 1e-12) {
            res = (res + x / res) / 2;
        }
        return res;
    }
    public static void main(String[] args) {
        return;
    }
}
