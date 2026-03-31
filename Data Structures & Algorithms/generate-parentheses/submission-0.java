class Solution {
   List<String> al = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int open = n, close = n;

        solve(open, close, "");

        Collections.sort(al);
        return al;
    }

    private void solve(int open, int close, String output) {
        if (open == 0 && close == 0) {
            al.add(output);
            return;
        }

        if (open != 0) {
            String output1 = new StringBuilder(output).append("(").toString();
            solve(open-1, close, output1);

        }

        if (close> open) {
            String output1 = new StringBuilder(output).append(")").toString();
            solve(open, close-1, output1);

        }
    }
}
