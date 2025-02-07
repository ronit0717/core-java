class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
        }
        int maxLis = 1;
        for (int i = 1; i < words.length; i++) {
            int maxVal = 1;
            for (int j = 0; j < i; j++) {
                if (compare(words[i], words[j])) {
                    int val = dp[i] + dp[j];
                    maxVal = Math.max(maxVal, val);
                }
            }
            dp[i] = maxVal;
            maxLis = Math.max(maxLis, maxVal);
        }
        return maxLis;
    }

    private boolean compare(String a, String b) {
        if (a.length() - b.length() != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == b.length() && (i >= a.length() - 1)) {
            return true;
        }
        return false;
    }
}