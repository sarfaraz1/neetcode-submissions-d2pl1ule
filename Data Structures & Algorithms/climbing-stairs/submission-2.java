class Solution {
     public int climbStairs(int n) {
        if (n == 1) return 1;
        if(n==2) return 2;


        int[] numberOfWays = new int[n + 1];
        numberOfWays[1] = 1;
        numberOfWays[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            numberOfWays[i] = numberOfWays[i - 2] + numberOfWays[i - 1];
        }
        return numberOfWays[n];
    }
}
