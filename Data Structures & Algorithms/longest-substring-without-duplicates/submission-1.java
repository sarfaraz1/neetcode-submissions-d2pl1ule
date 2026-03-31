class Solution {
     public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        char[] inputArr = s.toCharArray();
        int left = 0, right = 0;
        int len, maxLen = 0;
        while (right < inputArr.length) {
            if (charToIndexMap.get(inputArr[right]) == null || charToIndexMap.get(inputArr[right]) < left) {
                len = right - left + 1;
                charToIndexMap.put(inputArr[right], right);
                maxLen = Math.max(len, maxLen);
                right++;
            } else {
                left = charToIndexMap.get(inputArr[right]) + 1;
                charToIndexMap.put(inputArr[right], right);
                right++;
            }
        }
        return maxLen;
    }
}
