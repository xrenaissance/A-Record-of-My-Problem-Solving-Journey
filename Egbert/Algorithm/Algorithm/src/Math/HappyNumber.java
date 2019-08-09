package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5315930441646080
 * @leetcode https://leetcode.com/problems/happy-number/
 * @author Egbert Li
 * @date 2/7/2019
 * @Time log N
 * @Space O 1
 */
public class HappyNumber {
    /**
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = squareSum(n);
        }
        return true;
    }
    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    // Solution2 : slow and fast pointers
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }
    private static int findSquareSum(int num) {
        int digit = 0;
        int sum = 0;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(FastSlowPointers.HappyNumber.find(23));
        System.out.println(FastSlowPointers.HappyNumber.find(12));
    }
}
