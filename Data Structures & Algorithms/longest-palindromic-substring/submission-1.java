class Solution {
  public String longestPalindrome(String s) {
        int n = s.length(), count = 0, start = 0, maxLen = 1;
        boolean[][] t = new boolean[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;
                // length 1
                if (i == j)
                    t[i][j] = true;

                    // length 2
                else if (i + 1 == j) {
                    t[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    t[i][j] = s.charAt(i) == s.charAt(j) && t[i + 1][j - 1];
                }

                if (t[i][j] && L > maxLen) {
                    start = i;
                    maxLen = L;
                }


            }
        }
        return s.substring(start, start + maxLen);
    }
}
