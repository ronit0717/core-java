class Solution {

    // Function to find the intersection of two arrays
    ArrayList<Integer> intersection(int[] a, int[] b) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int prev = -1000000001;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                if (prev != a[i]) {
                    ans.add(a[i]);
                    prev = a[i];
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}