class Solution {
     public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count > 0)
                    break;
            }
        }

        return count;
    }
}