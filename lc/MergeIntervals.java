class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0])); //sort by start time
        int time = -1;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start > time) {
                //new non-overlapping interval
                list.add(new Integer[]{start, end});
            } else {
                //overlapping. Hence merge with last element
                int index = list.size() - 1; //last element
                end = Math.max(list.get(index)[1], end);
                list.get(index)[1] = end;
            }
            time = end;
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}