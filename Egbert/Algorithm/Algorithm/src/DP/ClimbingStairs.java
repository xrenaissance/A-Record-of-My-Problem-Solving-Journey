package DP;

/**
 * @author Egbert Li
 * @date 28/04/2019
 * Time: O(n)
 * Space: O(1)
 */
public class ClimbingStairs {
    public int stairs(int n) {
        if (n < 2) {
            return 1;
        }
        int oneStep = 1;
        int twoStep = 1;
        int i = 2;
        while (i < n) {
            int temp = twoStep;
            twoStep += oneStep;
            oneStep = temp;
            i++;
        }
        return oneStep + twoStep;
    }
}
