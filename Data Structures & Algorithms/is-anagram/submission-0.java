class Solution {
   public boolean isAnagram(String s, String t) {
        char[] stringArr1 = s.toCharArray();
        char[] stringArr2 = t.toCharArray();
        Arrays.sort(stringArr1);
        Arrays.sort(stringArr2);
        if (Arrays.equals(stringArr1, stringArr2))
            return true;

        return false;
    }
}
