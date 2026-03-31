class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> charToFreqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (charToFreqMap.get(c) == null) {
                charToFreqMap.put(c, 1);
            } else {
                charToFreqMap.put(c, charToFreqMap.get(c) + 1);
            }
        }

        int maxOdd = 1, minEven = 200;

        for (int freq : charToFreqMap.values()) {
            if (freq % 2 == 0)
                minEven = Math.min(minEven, freq);

            else
                maxOdd = Math.max(maxOdd, freq);

        }
        
        return maxOdd- minEven;
    }
}