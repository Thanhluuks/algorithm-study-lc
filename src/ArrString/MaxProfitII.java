package ArrString;

public class MaxProfitII {
    static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>buyPrice) {
                profit = profit + prices[i] - buyPrice;
                buyPrice = prices[i];
            } else buyPrice = Math.min(buyPrice, prices[i]);

        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));
    }
}
