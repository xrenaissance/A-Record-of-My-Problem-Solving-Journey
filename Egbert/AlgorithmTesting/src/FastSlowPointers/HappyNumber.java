package FastSlowPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5315930441646080
 * @author Egbert Li
 * @date 2/7/2019
 * @Time log N
 * @Space O 1
 */
public class HappyNumber {
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
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
