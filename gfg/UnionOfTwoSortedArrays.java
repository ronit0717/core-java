class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int prev = -1000000001;
        while(i < a.length && j < b.length) {
            int cand = 0;
            if (a[i] == b[j]) {
                cand = a[i];
                i++;
                j++;
            } else if (a[i] < b[j]) {
                cand = a[i];
                i++;
            } else {
                cand = b[j];
                j++;
            }
            if (prev != cand) {
                ans.add(cand);
                prev = cand;
            }
        }
        while (i < a.length) {
            int cand = a[i];
            if (prev != cand) {
                ans.add(cand);
                prev = cand;
            }
            i++;
        }
        while (j < b.length) {
            int cand = b[j];
            if (prev != cand) {
                ans.add(cand);
                prev = cand;
            }
            j++;
        }
        return ans;
    }
}