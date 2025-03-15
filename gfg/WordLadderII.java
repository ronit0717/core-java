class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        Set<String> wordSet = buildSet(wordList);
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> node = new ArrayList<>();
        node.add(startWord);
        q.add(node);
        if (wordSet.contains(startWord)) {
            wordSet.remove(startWord);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            boolean exit = false;
            Set<String> wordsToBeRemoved = new HashSet<>();
            for (int s = 0; s < size; s++) {
                node = q.poll();
                String word = node.get(node.size() - 1); //last word
                if (word.equals(targetWord)) {
                    exit = true;
                    result.add(node);
                    continue;
                } else if (exit) {
                    continue; //Wont go further in next level
                }
                Set<String> nextSet = getNextSet(word, wordSet);
                for (String next : nextSet) {
                    ArrayList<String> nextNode = new ArrayList<>(node);
                    nextNode.add(next);
                    q.add(nextNode);
                }
                wordsToBeRemoved.addAll(nextSet);
            }
            if (exit) {
                break;
            }
            wordSet.removeAll(wordsToBeRemoved);
        }
        return result;
    }
    
    private Set<String> getNextSet(String word, Set<String> wordSet) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char[] charArr = word.toCharArray();
                charArr[i] = c;
                String newWord = new String(charArr);
                if (wordSet.contains(newWord)) {
                    set.add(newWord);
                }
            }
        }
        return set;
    }
    
    private Set<String> buildSet(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        return set;
    } 
}