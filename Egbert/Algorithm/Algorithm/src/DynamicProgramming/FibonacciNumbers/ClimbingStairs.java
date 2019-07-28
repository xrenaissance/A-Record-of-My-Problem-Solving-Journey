package DynamicProgramming.FibonacciNumbers;

/**
 * @leetcode https://leetcode.com/problems/climbing-stairs/
 * @date 27/7/2019
 * @Time N
 * @Space 1
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] climb = new int[2];
        climb[0] = 1;
        climb[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = climb[1];
            climb[1] += climb[0];
            climb[0] = temp;
        }
        return climb[1];
    }
}
