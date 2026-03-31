class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> processedMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String retrieved = strs[i];
            char[] chars = retrieved.toCharArray();
            System.out.println("chars" + chars);
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            processedMap.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(retrieved);

        }

        List<List<String>> output = new ArrayList<>();
        for (var entry : processedMap.entrySet()) {
            output.add(entry.getValue());

        }
        return output;
    }
}
