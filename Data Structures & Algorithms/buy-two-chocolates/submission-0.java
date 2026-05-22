class Solution {
       public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int firstChoco = prices[0];
        int secondChoco = prices[1];

        int sum = firstChoco + secondChoco;
        if (sum <= money)
            return money - sum;

        return money;
    }
}