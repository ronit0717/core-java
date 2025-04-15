class Solution {
    public long subArrayRanges(int[] nums) {
        return subArrayMaximum(nums) - subArrayMinimum(nums);
    }

    private long subArrayMinimum(int[] nums) {
        int n = nums.length;
        int[] nseIndexArr = new int[n]; //next smaller
        int[] pseIndexArr = new int[n]; //previous smaller or equal
       
        Stack<Integer[]> st = new Stack<>();

        //build pse
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek()[0] > nums[i]) {
                st.pop();
            }
            int pseIndex = st.isEmpty() ? -1 : st.peek()[1];
            pseIndexArr[i] = pseIndex;
            st.push(new Integer[]{nums[i], i});
        }

        st = new Stack<>();

        //build nse
        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek()[0] >= nums[i]) {
                st.pop();
            }
            int nseIndex = st.isEmpty() ? n : st.peek()[1];
            nseIndexArr[i] = nseIndex;
            st.push(new Integer[]{nums[i], i});
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftCount = i - pseIndexArr[i];
            int rightCount = nseIndexArr[i] - i;
            long product = ((long)nums[i]) * (leftCount * rightCount);
            sum += product;
        }
        return sum;
    }

    private long subArrayMaximum(int[] nums) {
        int n = nums.length;
        int[] ngeIndexArr = new int[n]; //next greater
        int[] pgeIndexArr = new int[n]; //previous greater or equal
       
        Stack<Integer[]> st = new Stack<>();

        //build pse
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek()[0] < nums[i]) {
                st.pop();
            }
            int pgeIndex = st.isEmpty() ? -1 : st.peek()[1];
            pgeIndexArr[i] = pgeIndex;
            st.push(new Integer[]{nums[i], i});
        }

        st = new Stack<>();

        //build nse
        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek()[0] <= nums[i]) {
                st.pop();
            }
            int ngeIndex = st.isEmpty() ? n : st.peek()[1];
            ngeIndexArr[i] = ngeIndex;
            st.push(new Integer[]{nums[i], i});
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftCount = i - pgeIndexArr[i];
            int rightCount = ngeIndexArr[i] - i;
            long product = ((long)nums[i]) * (leftCount * rightCount);
            sum += product;
        }
        return sum;
    }
}