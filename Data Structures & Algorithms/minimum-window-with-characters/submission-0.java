class Solution {
  public String minWindow(String s, String t) {
        int n = s.length();
        char[] baseStringArr = s.toCharArray();
        Map<Character, Integer> charToFreqMap = new HashMap<>();
        char[] tChar = t.toCharArray();
        for (char c : tChar) {
            charToFreqMap.put(c, charToFreqMap.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, minLen = Integer.MAX_VALUE, count = charToFreqMap.size();
        int start = 0;

        while (j < n) {

            if (charToFreqMap.get(baseStringArr[j]) != null) {
                charToFreqMap.put(baseStringArr[j], charToFreqMap.get(baseStringArr[j]) - 1);

                if (charToFreqMap.get(baseStringArr[j]) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
                if (charToFreqMap.containsKey(baseStringArr[i])) {
                    charToFreqMap.put(baseStringArr[i], charToFreqMap.get(baseStringArr[i]) + 1);
                    if (charToFreqMap.get(baseStringArr[i]) > 0) {
                        count++;
                    }
                }
                i++;
            }


            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
