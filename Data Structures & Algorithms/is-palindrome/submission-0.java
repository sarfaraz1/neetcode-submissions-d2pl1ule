class Solution {
   public static boolean isPalindrome(String s) {
        String replacedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println("replacedString " + replacedString);
        System.out.println("replacedString " + s);
        char[] chars = replacedString.toCharArray();
        int j = chars.length - 1;
        for (int i = 0; i <= j; i++, j--) {
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }
}
