//Solution 2: Gives TLE after 33 test cases (Bottom Up Approach)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ansList = new ArrayList<>();
        Set<String> wordSet = buildSet(wordList);
        if (!wordSet.contains(endWord)) {
            return ansList;
        }
        wordSet.add(beginWord);
        Queue<List<String>> q = new LinkedList<>();
        List<String> cand = new ArrayList<>();
        cand.add(endWord);
        q.add(cand);
        while (!q.isEmpty()) {
            boolean exit = false;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                cand = q.poll();
                String word = cand.get(cand.size() - 1); //last word
                if (word.equals(beginWord)) {
                    ansList.add(cand);
                    exit = true;
                    continue;
                } else if (exit) {
                    continue; //wont go further in next level
                }
                Set<String> prevSet = getPrevSet(word, cand, wordSet);
                for (String prev : prevSet) {
                    List<String> newList = new ArrayList<>(cand);
                    newList.add(prev);
                    //System.out.println(newList);
                    q.add(newList);
                }
            }
            if (exit) {
                break;
            }
        }

        //reverse
        for (List<String> list : ansList) {
            Collections.reverse(list);
        }
        return ansList;
    }

    private Set<String> getPrevSet(String word, List<String> excludeList, Set<String> includeSet) {
        Set<String> excludeSet = buildSet(excludeList);
        Set<String> prevSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char[] wordCharArr = word.toCharArray();
                wordCharArr[i] = c;
                String newWord = new String(wordCharArr);
                if (!excludeSet.contains(newWord) 
                        && includeSet.contains(newWord) && !newWord.equals(word)) {
                    prevSet.add(newWord);
                }
            }
        }
        return prevSet;
    }

    private Set<String> buildSet(List<String> words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        return set;
    }
}

//Solution 1: Gives TLE after 33 test cases (Top Down Approach)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = buildSet(wordList);
        Queue<List<String>> q = new LinkedList<>();
        List<List<String>> ansList = new LinkedList<>();
        List<String> candList = new ArrayList<>();
        candList.add(beginWord);
        q.add(candList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        while(!q.isEmpty()) {
            boolean ansFound = false;
            int size = q.size();
            Set<String> wordListRemoveSet = new HashSet<>();
            Map<String, Set<String>> map = new HashMap<>();
            for (int s = 0; s < size; s++) {
                candList = q.poll();
                String word = candList.get(candList.size() - 1);
                if (word.equals(endWord)) {
                    ansList.add(candList);
                    ansFound = true;
                    continue;
                } else if (ansFound) {
                    continue; //wont go further
                }
                Set<String> nextSet;
                if(map.containsKey(word)) {
                    nextSet = map.get(word);
                } else {
                    nextSet = getNextSet(word, set);
                    map.put(word, nextSet);
                }
                for (String nextWord : nextSet) {
                    List<String> nextCandList = new ArrayList<>(candList);
                    nextCandList.add(nextWord);
                    q.add(nextCandList);
                }
                wordListRemoveSet.addAll(nextSet);
            }
            if (ansFound) {
                return ansList;
            }
            removeFromSet(wordListRemoveSet, set);
        }
        return ansList;
    }

    private void removeFromSet(Set<String> removeSet, Set<String> set) {
        set.removeAll(removeSet);
    }

    private Set<String> getNextSet(String word, Set<String> wordSet) {
        Set<String> nextSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char[] wordCharArr = word.toCharArray();
                wordCharArr[i] = c;
                String newWord = new String(wordCharArr);
                if (wordSet.contains(newWord) && !newWord.equals(word)) {
                    nextSet.add(newWord);
                }
            }
        }
        return nextSet;
    }

    private Set<String> buildSet(List<String> words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        return set;
    }
}