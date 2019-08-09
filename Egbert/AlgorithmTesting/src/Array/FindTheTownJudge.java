package Array;

/**
 * @leetcode https://leetcode.com/problems/find-the-town-judge/
 * @Time N
 * @Space N
 */
public class FindTheTownJudge {
    public int findJudge(int n, int[][] array) {
        if (array == null) {
            return -1;
        }
        int[] trust = new int[n + 1];
        int[] trusted = new int[n + 1];
        for (int i = 0; i < array.length; i++) {
            int p1 = array[i][0];
            int p2 = array[i][1];
            trust[p1]++;
            trusted[p2]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (trust[i] == 0 && trusted[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
