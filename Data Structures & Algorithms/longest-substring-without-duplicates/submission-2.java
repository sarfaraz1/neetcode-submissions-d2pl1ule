class Solution {
 public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0, ans = 0;
        Map<Character, Integer> charToFreqMap = new HashMap<>();
        while (j < n) {
            charToFreqMap.put(s.charAt(j), charToFreqMap.getOrDefault(s.charAt(j), 0) + 1);
            int windowSize = j - i + 1;
            if (charToFreqMap.size() == windowSize) {
                ans = Math.max(ans, windowSize);

            } else if (charToFreqMap.size() < windowSize) {
                while (charToFreqMap.size() < windowSize) {
                    charToFreqMap.put(s.charAt(i), charToFreqMap.get(s.charAt(i)) - 1);
                    if (charToFreqMap.get(s.charAt(i)) == 0)
                        charToFreqMap.remove(s.charAt(i));
                    i++;
                    windowSize = j - i + 1;
                }
            }

            j++;
        }

        return ans;
    }
}
