class Solution {
    public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        int[][] dp = new int[s.length()][t.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                int len = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    len = 1;
                    if ((i < (s.length() - 1)) && (j < (t.length() - 1))) {
                        len += dp[i + 1][j + 1];
                    }
                } else {
                    int len1 = 0;
                    int len2 = 0;
                    if (i < (s.length() - 1)) {
                        len1 = dp[i + 1][j];
                    }
                    if (j < (t.length() - 1)) {
                        len2 = dp[i][j + 1];
                    }
                    len = Math.max(len1, len2);
                }
                dp[i][j] = len;
            }
        }
        Map<String, Set<String>> mem = new HashMap<>();
        Set<String> set = evaluate(0, 0, dp[0][0], s, t, dp, mem);
        List<String> lcs = new LinkedList<>();
        for (String n : set) {
            lcs.add(n);
        }
        Collections.sort(lcs);
        return lcs;
    }
    
    private Set<String> evaluate(int i, int j, int len, String s, String t, int[][] dp, Map<String, Set<String>> mem) {
        if (i >= s.length() || j >= t.length() || len <= 0) {
            return null;
        }
        String key = i + "-" + j + "-" + len;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        Set<String> set = new HashSet<>();
        if (s.charAt(i) == t.charAt(j)) {
            char c = s.charAt(i);
            Set<String> next = evaluate(i + 1, j + 1, len - 1, s, t, dp, mem);
            if (next == null) {
                set.add(Character.toString(c));
            } else {
                for (String n : next) {
                    set.add(c + n);
                }
            }
        } else {
            int len1 = (i < (s.length() - 1)) ? dp[i + 1][j] : -1;
            int len2 = (j < (t.length() - 1)) ? dp[i][j + 1] : -1;
            if (len1 == -1 && len2 == -1) {
                //do nothing
            } else if (len1 == -1 || len2 > len1) {
                set = evaluate(i, j + 1, len, s, t, dp, mem);
            } else if (len2 == -1 || len1 > len2) {
                set = evaluate(i + 1, j, len, s, t, dp, mem);
            } else {
                Set<String> set1 = evaluate(i + 1, j, len, s, t, dp, mem);
                Set<String> set2 = evaluate(i, j + 1, len, s, t, dp, mem);
                for (String n : set1) {
                    set.add(n);
                }
                for (String n : set2) {
                    set.add(n);
                }
            }
        }
        mem.put(key, set);
        return set;
    }
    
}