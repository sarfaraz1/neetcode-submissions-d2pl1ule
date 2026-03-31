class Solution {
    public int characterReplacement(String s, int k) {
        char[] inputArr = s.toCharArray();
        int windowSize = 0, maxFreq = 0, left = 0, right = 0, maxLength = 0;
        Map<Character, Integer> charToFreqMap = new HashMap<>();
        while (right < s.length()) {
            charToFreqMap.put(inputArr[right], charToFreqMap.getOrDefault(inputArr[right], 0) + 1);
            windowSize = right - left + 1;
            maxFreq = Math.max(maxFreq, charToFreqMap.get(inputArr[right]));
            if (windowSize - maxFreq > k) {
                charToFreqMap.put(inputArr[left], charToFreqMap.get(inputArr[left]) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;
    }
}
