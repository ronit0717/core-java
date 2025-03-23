//Problem Link: https://www.geeksforgeeks.org/problems/alien-dictionary/1

class Solution {
    public String findOrder(String[] words) {
        boolean[] valid = buildValidCharacter(words);
        List<Set<Integer>> graph = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            graph.add(new HashSet<>());
        }
        boolean check = buildGraph(words, graph);
        if (!check) {
            return "";
        }
        return printDictionary(graph, valid);
    }
    
    private String printDictionary(List<Set<Integer>> graph, boolean[] valid) {
        int[] inDegree = buildInDegree(graph);
        Queue<Integer> q = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        int validSize = 0;
        for (int i = 0; i < 26; i++) {
            if (!valid[i]) {
                continue;
            }
            validSize++;
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append((char)('a' + node));
            for (int next : graph.get(node)) {
                inDegree[next] -= 1;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        String dict = sb.toString();
        if (dict.length() != validSize) {
            return ""; //cycle
        }
        return dict;
    }
    
    private int[] buildInDegree(List<Set<Integer>> graph) {
        int[] inDegree = new int[26];
        for (int i = 0; i < graph.size(); i++) {
            for (int next : graph.get(i)) {
                inDegree[next] += 1;
            }
        }
        return inDegree;
    }
    
    private boolean buildGraph(String[] words, 
                   List<Set<Integer>> graph) {
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            for (int j = 0; j < word1.length(); j++) {
                if (j == word2.length()) {
                    return false;
                }
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    continue;
                }
                int indexC1 = c1 - 'a';
                int indexC2 = c2 - 'a';
                
                graph.get(indexC1).add(indexC2);
                break;
            }
        }
        return true;
    }
    
    private boolean[] buildValidCharacter(String[] words) {
        boolean[] valid = new boolean[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                valid[charIndex] = true;
            }
        }
        return valid;
    }
    
}