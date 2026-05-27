class Solution {
     public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                max = Math.max(max, (int) entry.getKey());
            }

        }
        return max;
    }
}