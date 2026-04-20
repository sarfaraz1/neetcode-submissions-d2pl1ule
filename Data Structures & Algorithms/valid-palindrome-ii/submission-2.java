class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1, count = 1;


        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(left, right)) || isPalindrome(s.substring(left + 1, right+1));

            }
            left++;
            right--;
        }
        return true;

    }

    private boolean isPalindrome(String substring) {
        String reversed = new StringBuilder(substring).reverse().toString();
        return reversed.equals(substring);
    }
}