/** NOTE: Code needs further optimisation */

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
        Set<String> set = new HashSet<>();
        List<String> answer = new LinkedList<>();
        int lcsLength = dp[0][0];
        if (lcsLength == 0) {
            return answer;
        }
        char[] cand = new char[lcsLength];
        Set<String> mem = new HashSet<>();
        evaluate(set, dp, 0, 0, s, t, cand, 0, mem);
        for (String st : set) {
            answer.add(st);
        }
        Collections.sort(answer);
        return answer;
    }
    
    private void evaluate(Set<String> set, 
                            int[][] dp, 
                            int i, int j, String s, String t, 
                            char[] cand, int pointer, Set<String> mem) {
        String check = i + "-" + j + "-" + buildString(cand, pointer);
        if (mem.contains(check)) {
            return;
        }
        mem.add(check);
        if (pointer == cand.length) {
            set.add(buildString(cand, pointer));
            return;
        }
        if (s.charAt(i) == t.charAt(j)) {
            cand[pointer] = s.charAt(i);
            if (pointer == cand.length - 1) {
                set.add(buildString(cand, pointer + 1));
                return;
            }
            if (i < (s.length() - 1) && (j < (t.length() - 1))) {
                evaluate(set, dp, i + 1, j + 1, s, t, cand, pointer + 1, mem);
            }
        } else {
            if (i == (s.length() - 1) && j == (t.length() - 1)) {
                return;
            } else if (j == (t.length() - 1)) {
                evaluate(set, dp, i + 1, j, s,t, cand, pointer, mem);
            } else if (i == (s.length() - 1)) {
                evaluate(set, dp, i, j + 1, s,t, cand, pointer, mem);
            } else {
                if (dp[i][j + 1] == dp[i][j + 1]) {
                    if (s.charAt(i + 1) < t.charAt(j + 1)) {
                        evaluate(set, dp, i + 1, j, s, t, cand, pointer, mem);
                        evaluate(set, dp, i, j + 1, s, t, cand, pointer, mem);    
                    } else {
                        evaluate(set, dp, i, j + 1, s, t, cand, pointer, mem);    
                        evaluate(set, dp, i + 1, j, s, t, cand, pointer, mem);
                    }
                    
                } else if (dp[i][j + 1] > dp[i + 1][j]) {
                    evaluate(set, dp, i, j + 1, s, t, cand, pointer, mem);
                } else {
                    evaluate(set, dp, i + 1, j, s, t, cand, pointer, mem);
                }
            }
        }
    }
    
    private String buildString(char[] cand, int pointer) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < pointer; k++) {
            sb.append(cand[k]);
        }
        return sb.toString();
    }
}