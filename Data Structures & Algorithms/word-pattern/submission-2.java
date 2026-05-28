class Solution {
      public boolean wordPattern(String pattern, String s) {
        String[] inputStrings = s.split(" ");
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();

        if (pattern.length() != inputStrings.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String word = inputStrings[i];
            if (charToWordMap.containsKey(c) && !word.equals(charToWordMap.get(pattern.charAt(i)))) {
                return false;
            } else {
                charToWordMap.put(pattern.charAt(i), inputStrings[i]);
            }


            if (wordToCharMap.containsKey(word) && !wordToCharMap.get(word).equals(c))
                return false;
            else {
                wordToCharMap.put(word, c);
            }

        }
        return true;
    }
}