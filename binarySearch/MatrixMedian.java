import java.util.ArrayList;

public class Solution {
    private static HashSet<Integer> hs;

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        hs = new HashSet<Integer>();
        int N = A.size();
        int M = (A.get(0)).size();
        int total = N*M;
        int x = (total-1)/2;

        int answer = -1;
        int ans_count = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int curr = (A.get(i)).get(j);

                /*
                if(hs.contains(curr)){
                    continue;
                }else{
                    hs.add(curr);
                }
                */
                
                int count = getCount(A, curr);

                //System.out.println("CURR :"+curr+" Count:"+count);

                if(count > ans_count && count <= x){
                    //System.out.println("Inside Curr: "+curr);
                    answer = curr;
                    ans_count = count;
                }
            }
        }

        return answer;

    }

    private static int getCount(ArrayList<ArrayList<Integer>> A, int curr){
        int count = 0;
        int N = A.size();
        int M = A.get(0).size();
        for(int i=0; i< N; i++){
            int start = 0;
            int end = M-1;
            while(start <= end){
                int mid = (start+end)/2;
                int check = (A.get(i)).get(mid);
                if(check < curr){
                    //move right
                    count += mid-start+1;
                    start = mid+1;

                }else if(check >= curr){
                    //move left
                    end = mid-1;
                }
            }
        }
        return count;
    }
}
