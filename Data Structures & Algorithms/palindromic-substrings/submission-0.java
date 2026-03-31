class Solution {
int[][] palindromeResult = new int[1000][1000];

    public int isPalindrome(String s, int i, int j) {
        if (i >= j)
            return palindromeResult[i][j] = 1;


        if (palindromeResult[i][j] != -1)
            return palindromeResult[i][j];
        else {
            if (s.charAt(i) == s.charAt(j)) {
                return palindromeResult[i][j] = isPalindrome(s, i + 1, j - 1);
            }
        }
        return palindromeResult[i][j] = -1;
    }

    public int countSubstrings(String s) {
        int palindromeCount = 0;


        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                palindromeResult[i][j] = -1;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j) == 1) {
                    palindromeCount++;
                }

            }
        }
        return palindromeCount;
    }
}
