package ArrString;

public class MaxProfit {
    static int maxProfit(int[] prices) {
        int cheap = prices[0];
        int profix =0;
        for (int i = 1; i < prices.length; i++) {
            cheap = Math.min(cheap, prices[i]);
            profix = Math.max(profix,prices[i] - cheap);
        }
        return profix;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
