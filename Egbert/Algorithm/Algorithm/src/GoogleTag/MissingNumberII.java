package GoogleTag;
/**
 * @author Egbert Li
 * @Date 26/03/2019
 * Time Complexity O(log n), Space Complexity is O(1)
 */
public class MissingNumberII {
    public int missing(int[] array) {
        if (array == null || array.length == 0) {
            return 1;
        }
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // handle if last number is the less or more than it's suppose to be
        if (array[left] == left + 1) {
            return array[left] + 1;
        }
        return array[left] - 1;
    }
}
