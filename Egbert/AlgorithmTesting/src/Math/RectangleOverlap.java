package Math;

/**
 * @leetcode https://leetcode.com/problems/rectangle-overlap/
 * @Time O 1
 * @Space O 1
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int l1x = rec1[0];
        int l1y = rec1[1];
        int r1x = rec1[2];
        int r1y = rec1[3];

        int l2x = rec2[0];
        int l2y = rec2[1];
        int r2x = rec2[2];
        int r2y = rec2[3];

        if (l2y >= r1y || l1y >= r2y) {
            return false;
        }
        if (l2x >= r1x || l1x >= r2x) {
            return false;
        }
        return true;
    }
}
