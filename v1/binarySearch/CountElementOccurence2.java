import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    private static int count = 0;
    public int findCount(final List<Integer> A, int B) {
        int start = 0;
        int end = A.size() - 1;
        count = 0;
        
        getCount(A, start, end, B);
        return count;

    }

    private static void getCount(List<Integer> A, int start, int end, int B){
        if(end < start){
            return;
        }
        
        int mid = (start+end)/2;

        if(A.get(mid) == B){
            count++;
            //move both ways
            getCount(A, start, (mid-1), B);
            getCount(A, (mid+1), end, B);
        }else if(A.get(mid) > B){
            //move left
            getCount(A, start, (mid-1), B);
        }else{
            //move right
            getCount(A, (mid+1), end, B);

        }


    }
}
