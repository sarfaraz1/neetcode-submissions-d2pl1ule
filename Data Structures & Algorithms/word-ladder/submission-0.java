class Solution {
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        wordSet.remove(beginWord);

        while (!q.isEmpty()) {
            Pair node = q.poll();
            String word = node.word;
            int level = node.level;
            if (word.equals(endWord)) return level;
            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] charArr = word.toCharArray();
                    charArr[i] = j;
                    String replacedWord = new String(charArr);
                    if (wordSet.contains(replacedWord)) {
                        q.add(new Pair(replacedWord, level + 1));
                        wordSet.remove(replacedWord);
                    }

                }

            }

        }

        return 0;
    }

    class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }

    }
}
