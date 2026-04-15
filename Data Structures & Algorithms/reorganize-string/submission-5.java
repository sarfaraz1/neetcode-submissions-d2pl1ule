class Solution {
    public String reorganizeString(String s) {
        int n = s.length(), maxFreq = 0, freq;
        Character maxFreqChar = null;
        if (n == 1) return s;


        Map<Character, Integer> charToFreqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq = charToFreqMap.getOrDefault(s.charAt(i), 0) + 1;
            charToFreqMap.put(s.charAt(i), freq);
            if (freq > maxFreq) {
                maxFreq = freq;
                maxFreqChar = s.charAt(i);
            }

        }

        if (maxFreq > Math.ceil((double) n / 2)) {
            return "";
        }

        char[] ans = s.toCharArray();

        int i, j;
        for (i = 0, j = maxFreq; j > 0; i = i + 2, j--) {
            ans[i] = maxFreqChar;
        }
        charToFreqMap.remove(maxFreqChar);

        for (char c = 'a'; c <= 'z'; c++) {
            while (charToFreqMap.get(c) != null && charToFreqMap.get(c) > 0) {
                if (i >= n) {
                    i = 1;
                }
                ans[i] = c;
                charToFreqMap.put(c, charToFreqMap.get(c) - 1);


                i = i + 2;
            }

        }


        return new String(ans);
    }
}