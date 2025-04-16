package Interview;

public class BestTimeToBuyAndSellStockGood {

	public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // Output: 0

        int[] prices3 = {2, 4, 1};
        System.out.println(maxProfit(prices3)); // Output: 2
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minStockVal = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minStockVal = Math.min(minStockVal, prices[i]);
            if (prices[i] >= minStockVal) {
                maxProfit = Math.max(maxProfit, prices[i] - minStockVal);
            }
        }

        return maxProfit;
    }

}
