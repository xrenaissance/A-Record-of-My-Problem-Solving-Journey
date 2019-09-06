package Subsets;

import java.util.Comparator;

public class CombinationOfCoins {
    // Solution 1: Dp
    // dp[i][j]: the number of combinations to make up
    // amount j buy using first i types of coins
    // 1. not using ith coin, only using first i - 1coins to make up amount j
    // we have dp[i - 1][j] ways

    public static int changeDP(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
    // Solution 2: DFS  Time: (amount/min(coins)) ^ coins.length
    // Space: coins.length
    public static int change(int amount, int[] coins) {
        if ((coins == null || coins.length == 0) && amount == 0) {
            return 1;
        }
        int[] total = new int[1];
        helper(coins, amount, 0, total);
        return total[0];
    }
    private static void helper(int[] coins, int moneyLeft,
                        int level, int[] total) {
        if (level == coins.length) {
            if (moneyLeft == 0) {
                total[0]++;
            }
            return;
        }
        for (int i = 0; i <= moneyLeft / coins[level]; i++) {
            // moneyLeft -= coins[level] * i;
            helper(coins, moneyLeft - coins[level] * i, level + 1, total);
        }
    }
    public static void main(String[] args) {
        int[] coins = new int[]{3,5,7,8,9,10,11};
        long start = System.currentTimeMillis();
        System.out.println("DFS total: " +
                CombinationOfCoins.change(500, coins) + " combinations.");
        long finish = System.currentTimeMillis();
        System.out.println("DFS Time laps: "+ (finish - start) + " ms.");
        long dfsTime = start - finish;

        start = System.currentTimeMillis();
        System.out.println("DP total: " +
                CombinationOfCoins.changeDP(500, coins) + " combinations.");
        finish = System.currentTimeMillis();
        System.out.println("DP Time laps: " + (finish - start) + " ms.");
        System.out.println("DFS/DP : " + (finish - start)/dfsTime);
    }
}
