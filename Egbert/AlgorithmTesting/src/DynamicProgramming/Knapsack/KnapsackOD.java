package DynamicProgramming.Knapsack;

public class KnapsackOD {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        // dp[c] = maximum profit while capacity is c
        // at any weight there are two state, include current weight or not
        // if include then the profit will be profit1 = dp[c - w[i]] + p[i]
        // if not it will be profit2 = max(p[i], dp[c - w[i])
        // dp[c] = max(profit1, profit2)
        int[] dp = new int[capacity + 1];
        for (int c = 1; c <= capacity; c++) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
