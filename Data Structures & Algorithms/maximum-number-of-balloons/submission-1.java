class Solution {
    int ans = Integer.MAX_VALUE;

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> balloonMap = new HashMap<>();
        initializeBalloonMap(balloonMap);
        Map<Character, Integer> textMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (balloonMap.containsKey(c)) {
                textMap.put(c, textMap.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry entry : balloonMap.entrySet()) {
            if (textMap.containsKey(entry.getKey())) {
                textMap.put((char) entry.getKey(), textMap.get(entry.getKey()) / (int) entry.getValue());
            } else {
                return 0;
            }

        }

        for (Map.Entry entry : textMap.entrySet()) {
            ans = Math.min(ans, (int) entry.getValue());

        }
        return ans;
    }

    private void initializeBalloonMap(Map<Character, Integer> charToFreqMap) {
        for (char c : "balloon".toCharArray()) {
            charToFreqMap.put(c, charToFreqMap.getOrDefault(c, 0) + 1);
        }
    }
}