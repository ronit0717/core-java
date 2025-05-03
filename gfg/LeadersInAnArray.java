class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> leaders = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
