class Solution {
  public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        while (i + j < haystack.length()) {
            if (haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
                if (j == needle.length())
                    break;
            } else {
                i++;
                j = 0;
            }

        }

        if (j == needle.length())
            return i;

        return -1;
    }
}