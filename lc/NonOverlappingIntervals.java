class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1])); //sort by end time
        int time = -50000;
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (time > intervals[i][0]) {
                count++; //count and skip
            } else {
                time = intervals[i][1];
            }
        }
        return count;
    }
}