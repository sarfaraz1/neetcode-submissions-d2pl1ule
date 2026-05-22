class Solution {
      public int buyChoco(int[] prices, int money) {
        int min2;
        int min1 = min2 = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min1) {
                int temp = min1;
                min1 = price;
                min2 = temp;

            } else if (price < min2) {
                min2 = price;
            }
        }
        int sum = min1 + min2;

        if (sum <= money)
            return money - sum;

        return money;
    }
}