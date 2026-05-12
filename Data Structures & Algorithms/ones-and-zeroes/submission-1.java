class Solution {
    int[][][] t;

    public int findMaxForm(String[] strs, int m, int n) {
        List<Count> countList = countZerosAndOnes(strs);
        t = new int[m + 1][n + 1][strs.length];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(t[i][j], -1);

            }

        }

        return solve(0, strs, countList, m, n);

    }

    private int solve(int index, String[] strs, List<Count> countList, int m, int n) {
        if (index == strs.length || (m == 0 && n == 0)) {
            return 0;
        }

        if (t[m][n][index] != -1)
            return t[m][n][index];

        // take
        int take = 0;
        if (m - countList.get(index).zeroes >= 0 && n - countList.get(index).ones >= 0) {
            take = 1 + solve(index + 1, strs, countList, m - countList.get(index).zeroes, n - countList.get(index).ones);
        }

        int notTake = solve(index + 1, strs, countList, m, n);

        return t[m][n][index] = Math.max(take, notTake);
    }

    private List<Count> countZerosAndOnes(String[] strs) {
        List<Count> countList = new ArrayList<>();

        for (String str : strs) {
            int zeroes = 0, ones = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    zeroes++;
                else
                    ones++;
            }
            countList.add(new Count(zeroes, ones));
        }
        return countList;
    }


    class Count {
        int zeroes;
        int ones;

        Count(int zeroes, int ones) {
            this.zeroes = zeroes;
            this.ones = ones;
        }

    }
}