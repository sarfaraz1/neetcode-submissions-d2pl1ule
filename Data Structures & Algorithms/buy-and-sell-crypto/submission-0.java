class Solution {
 public int maxProfit(int[] prices) {
        int[] minArr = new int[prices.length];
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            min = Math.min(min, prices[i]);
            minArr[i] = min;
        }

        for (int i = prices.length - 1; i > 0; i--) {
            maxProfit = Math.max(maxProfit, prices[i] - minArr[i - 1]);
        }

        return maxProfit;
    }
}
