class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        
        //sort desc
        String delimiter = "-";
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        List<Integer> ans = new ArrayList<>(K);
        
        //add first sum to pq (highest sum possible)
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a , b) -> (b[0] - a[0])); //max heap
        Set<String> set = new HashSet<>();
        
        pq.add(new Integer[]{A[N - 1] + B[N-1], N-1, N-1});
        set.add((N-1) + delimiter + (N-1));
        
        for (int c = 0; c < K; c++) {
            Integer[] cand = pq.poll();
            ans.add(cand[0]);
            
            int i = cand[1];
            int j = cand[2];
            
            int newI = i - 1;
            int newJ = j - 1;
            
            String pair1 = newI + delimiter + j;
            if (newI >= 0 && !set.contains(pair1)) {
                pq.add(new Integer[]{ A[newI] + B[j], newI, j});
                set.add(pair1);
            }
            
            String pair2 = i + delimiter + newJ;
            if (newJ >= 0 && !set.contains(pair2)) {
                pq.add(new Integer[]{ A[i] + B[newJ], i, newJ});
                set.add(pair2);
            }
        }
        return ans;
    }
}