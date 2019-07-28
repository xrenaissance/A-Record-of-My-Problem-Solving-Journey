package Math;

/**
 * @leetcode https://leetcode.com/problems/valid-perfect-square/
 * @date 28/7/2019
 * @Time log N
 * @Space 1
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right * right == num;
    }
}

