class Solution {
     public int climbStairs(int n) {
    

        int[] numberOfWays = new int[n + 1];
        numberOfWays[0] = 1;
        numberOfWays[1] = 1;


        for (int i = 2; i < n + 1; i++) {
            numberOfWays[i] = numberOfWays[i - 2] + numberOfWays[i - 1];
        }
        return numberOfWays[n];
    }
}
