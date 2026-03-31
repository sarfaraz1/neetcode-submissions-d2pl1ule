class Solution {
   public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = getHours(piles, mid);

            if (hours <= h)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    private int getHours(int[] piles, int rateOfEating) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / rateOfEating);
        }
        return hours;
    }
}
