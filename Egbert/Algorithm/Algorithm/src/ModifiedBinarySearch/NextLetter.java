package ModifiedBinarySearch;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/4850551927865344
 * @leetcode https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * @author Egbert Li
 * @Time O log N
 * @Space O1
 */
public class NextLetter {
    public static char searchNextLetter(char[] letters, char key) {
        int n = letters.length;
        if (key < letters[0] || key > letters[n - 1]) {
            return letters[0];
        }
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else { //if (key >= letters[mid]) {
                start = mid + 1;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        return letters[start % n];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
