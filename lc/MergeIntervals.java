class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        ArrayList<Integer[]> list = new ArrayList<>();
        boolean newSet = true;
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            boolean merge = true;
            if (intervals[i][0] <= max) {
                max = Math.max(intervals[i][1], max);
            } else {
                //no merge
                merge = false;
            }
            
            if (!merge) {
                Integer[] element = {min, max};
                list.add(element);
                
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        
        Integer[] element = {min, max};
        list.add(element);   
        
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k][0] = list.get(k)[0];
            res[k][1] = list.get(k)[1];
        }
        return res;
    }
}