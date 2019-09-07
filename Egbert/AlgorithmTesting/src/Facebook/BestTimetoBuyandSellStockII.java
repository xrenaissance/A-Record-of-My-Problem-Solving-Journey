package Facebook;

/**
 * @leetcode https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Time N
 * @Space 1
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = 0;
        int peakPrice = 0;
        int index = 0;
        int profit = 0;
        while (index < prices.length - 1) {
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            minPrice = prices[index];

            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            peakPrice = prices[index];

            profit += peakPrice - minPrice;
            index++;
        }

        return profit;
    }
}
