class Solution {
  List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {

        ArrayList<String> temp = new ArrayList<>();

        solve(s, 0, temp);
        return ans;

    }

    private void solve(String s, int index, ArrayList<String> temp) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        String plString = "";

        for (int i = index; i < s.length(); i++) {
            plString += s.charAt(i);
            if (isPlaindrome(plString, 0, plString.length() - 1)) {
                temp.add(plString);
                solve(s, i + 1, temp);
                temp.remove(temp.size() - 1);

            }


        }
    }

    private boolean isPlaindrome(String plString, int i, int j) {
        if (i >= j)
            return true;

        else if (plString.charAt(i) == plString.charAt(j)) {
            i++;
            j--;
            return isPlaindrome(plString, i, j);
        }
        return false;
    }
}
