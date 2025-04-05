class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer[]> list = new LinkedList<>();
        int mergeStart = newInterval[0];
        int mergeEnd = newInterval[1];
        boolean merged = false;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (end < newInterval[0]) {
                list.add(new Integer[]{start, end});
            } else if(start > newInterval[1]) {
                if (!merged) {
                    list.add(new Integer[]{mergeStart, mergeEnd});
                    merged = true;
                }
                list.add(new Integer[]{start, end});
            } else {
                //Merge case
                mergeStart = Math.min(mergeStart, start);
                mergeEnd = Math.max(mergeEnd, end);
            }
        }
        if (!merged) {
            list.add(new Integer[]{mergeStart, mergeEnd});
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}