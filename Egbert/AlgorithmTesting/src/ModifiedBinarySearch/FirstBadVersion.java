package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/first-bad-version/
 * @date 14/7/2019
 * @Time Log N
 * @Space O 1
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
