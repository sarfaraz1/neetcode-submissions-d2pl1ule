class Solution {
        public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        int[] numberOfWays = new int[s.length() + 1];
        numberOfWays[0] = 1;
        numberOfWays[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int singleValue = Integer.valueOf(s.substring(i - 1, i));
            int doubleValue = Integer.valueOf(s.substring(i - 2, i));

            if (singleValue >= 1)
                numberOfWays[i] += numberOfWays[i - 1];
            if (10 <= doubleValue && doubleValue <= 26)
                numberOfWays[i] += numberOfWays[i - 2];

        }

        return numberOfWays[s.length()];
    }
}
