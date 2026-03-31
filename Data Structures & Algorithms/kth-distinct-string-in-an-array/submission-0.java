class Solution {
  public String kthDistinct(String[] arr, int k) {
        int n = arr.length;
        Map<String, Integer> stringToFreqMap = new LinkedHashMap<>();

        for (String s : arr) {
            stringToFreqMap.put(s, stringToFreqMap.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry entry : stringToFreqMap.entrySet()) {
            if ((int) entry.getValue() == 1) {
                k--;

                if (k == 0)
                    return entry.getKey().toString();

            }
        }
        
        return "";

    }
}