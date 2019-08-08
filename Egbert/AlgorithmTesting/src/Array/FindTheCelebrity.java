package Array;
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/**
 * @leetcode https://leetcode.com/problems/find-the-celebrity/
 * @Time N
 * @Space 1
 */
public class FindTheCelebrity {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != celebrity && knows(celebrity, i)) {
                return -1;
            }
            if (i != celebrity && !knows(i, celebrity)) {
                return -1;
            }
        }
        return celebrity;
    }
    private boolean knows(int a, int b) {
        return true;
    }
}
