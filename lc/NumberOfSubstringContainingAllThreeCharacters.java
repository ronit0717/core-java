class Solution {
    public int numberOfSubstrings(String s) {
        int aPos = -1;
        int bPos = -1;
        int cPos = -1;
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == 'a') {
                aPos = j;
            } else if (c == 'b') {
                bPos = j;
            } else {
                cPos = j;
            }
            if (!hasAllThree(aPos, bPos, cPos)) {
                continue;
            }
            int minPos = getStartOfMinSubstring(aPos, bPos, cPos);
            count += (minPos + 1);
        }
        return count;
    }

    private int getStartOfMinSubstring(int aPos, int bPos, int cPos) {
        return Math.min(aPos, Math.min(bPos, cPos));
    }

    private boolean hasAllThree(int aPos, int bPos, int cPos) {
        if (aPos == -1 || bPos == -1 || cPos == -1) {
            return false;
        }
        return true;
    }
}