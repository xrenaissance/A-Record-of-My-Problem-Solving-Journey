package Array;
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/**
 * @leetcode https://leetcode.com/problems/find-the-celebrity/
 * @Time N
 * @Space 1
 */
// it is inductive that we can find the candidate and check whether
// it is up to standard or not.
// How do we decide the candidate?
// We are sure that if A knows B, A cannot be the celebrity while B may be,
// i.e., B is the candidate. Since there is only one celebrity,
// one loop is enough to decide the candidate.
// How do we check whether the candidate is up to standard?
// According to the definition of a celebrity,
// if !knows(i, candidate) || knows(candidate, i) exists, the candidate is not qualified.0
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
