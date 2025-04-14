class Solution {
    public int sumSubarrayMins(int[] arr) {
        int large = 1000000007;
        int n = arr.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        for (int i = 0; i < n; i++) {
            nse[i] = n;
            pse[i] = -1;
        }

        Stack<Integer[]> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek()[0] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nse[i] = st.peek()[1];
            }
            st.push(new Integer[]{arr[i], i});
        }

        st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek()[0] > arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                pse[i] = st.peek()[1];
            }
            st.push(new Integer[]{arr[i], i});
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            //System.out.println(i + " -> pse: " + pse[i] + " nse: " + nse[i]); 
            long leftCount = (long)i - pse[i];
            long rightCount = (long)nse[i] - i;
            long product = (((leftCount * rightCount) % large) * (arr[i] % large)) % large;
            count = (count % large +  (int)product) % large;
        }
        return count;
    }
}