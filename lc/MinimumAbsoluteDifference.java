class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff <= min) {
                List<Integer> setList = new LinkedList<>();
                setList.add(arr[i - 1]);
                setList.add(arr[i]);
                if (diff < min) {
                    min = diff;
                    res = new LinkedList<>();
                }
                res.add(setList);
            }
        }
        return res;
    }
}