package Facebook;

/**
 * @leetcode https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @Time N
 * @Space 1
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        // dp[i] = max(maxProfit, prices[i] - minPrice)
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
