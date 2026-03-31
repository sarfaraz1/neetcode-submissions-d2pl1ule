class Solution {
  public boolean checkInclusion(String s1, String s2) {
        char[] inputArr1 = s1.toCharArray();
        char[] inputArr2 = s2.toCharArray();

        int[] freq1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[inputArr1[i] - 'a']++;
        }

        int windowSize = inputArr1.length;

        for (int i = 0; i < inputArr2.length; i++) {
            int windIndex = 0;
            int j=i;
            int[] freq2 = new int[26];
            while (windIndex < windowSize && j < inputArr2.length) {
                freq2[inputArr2[j] - 'a']++;
                windIndex++;
                j++;
            }

            if (isSameFreq(freq1, freq2))
                return true;
        }
        return false;
    }

    private boolean isSameFreq(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i])
                return false;

        }
        return true;
    }

}
