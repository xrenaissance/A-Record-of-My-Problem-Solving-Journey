package Math;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/sum-of-square-numbers/
 * @date 27/7/2019
 * @Time sqrt(c) for both solution
 * @Space 1 for two pointers, sqrt(c) for set
 */
public class SumofSquareNumbers {
    // Solution 1: Two pointers
    public boolean judgeSquareSumTwoPointers(int c) {
        if (c <= 1) {
            return true;
        }
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left <= right) {
            int curr = left * left + right * right;
            if (curr == c) {
                return true;
            } else if (curr < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // Solution 2: N
    public boolean judgeSquareSum(int c) {
        if (c <= 1) {
            return true;
        }
        Set<Integer> set = new HashSet();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (!set.add(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}
