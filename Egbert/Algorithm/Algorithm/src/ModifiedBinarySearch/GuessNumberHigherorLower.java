package ModifiedBinarySearch;
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
/**
 * @Leetcode https://leetcode.com/problems/guess-number-higher-or-lower/
 * @Time log n
 * @Space 1
 */
public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int result = 0;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private int guess(int n) {
        return 0;
    }
}
