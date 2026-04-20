class Solution {
       public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;


        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(left, right)) || isPalindrome(s.substring(left + 1, right + 1));

            }
            left++;
            right--;
        }
        return true;

    }

    private boolean isPalindrome(String substring) {
        int n = substring.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (substring.charAt(left) != substring.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}