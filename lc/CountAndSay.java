class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String previous = countAndSay(n - 1);
        return buildStringFromPrevious(previous);
    }

    private String buildStringFromPrevious(String previous) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char previousCharacter = previous.charAt(0);
        for (int i = 1; i < previous.length(); i++) {
            char c = previous.charAt(i);
            if (c == previousCharacter) {
                count++;
                continue;
            }
            sb.append(count);
            sb.append(previousCharacter);
            count = 1;
            previousCharacter = c;
        }

        sb.append(count);
        sb.append(previousCharacter);
        return sb.toString();
    }
}