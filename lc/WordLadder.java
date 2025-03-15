class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = buildSet(wordList);
        Queue<Object[]> q = new LinkedList<>(); 
        Object[] node = new Object[]{beginWord, 1};
        q.add(node);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                node = q.poll();
                String word = (String)node[0];
                int len = (int)node[1];
                if (word.equals(endWord)) {
                    return len;
                }
                for (int i = 0; i < word.length(); i++) {
                    List<String> newWordList = check(i, word, set);
                    removeFromSet(set, newWordList);
                    for (String newWord : newWordList) {
                        Object[] nextNode = new Object[]{newWord, len + 1};
                        q.add(nextNode);
                    }
                }
            }
        }
        return 0;
    }

    private void removeFromSet(Set<String> set, List<String> words) {
        for (String word : words) {
            set.remove(word);
        }
    }

    private List<String> check(int index, String word, Set<String> set) {
        List<String> matchedString = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            char[] cArr = word.toCharArray();
            cArr[index] = c;
            String newWord = new String(cArr);
            if (newWord.equals(word)) {
                continue;
            }
            if (set.contains(newWord)) {
                matchedString.add(newWord);
            }
        }
        return matchedString;
    }

    private Set<String> buildSet(List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        return set;
    }
}