class Solution {
    public int minSwaps(String s) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                count--;
            } else {
                count++;
                maxCount = Math.max(count, maxCount);
            }
        }
        return (maxCount / 2 + maxCount % 2); 
    }
}