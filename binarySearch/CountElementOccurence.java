import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findCount(final List<Integer> A, int B) {
        int start = 0;
        int end = A.size() - 1;
        int count = 0;
        
        while(start <= end){
            int mid = (start+end)/2;
            if(A.get(mid) < B){
                start = mid+1;    
            }else if(A.get(mid) > B){
                end = mid-1;
            }else{
                count++;
                
                //boundary check
                int checkLeft = mid-1;
                int checkRight = mid+1;
                
                while(true){
                    if(checkLeft < 0){
                        break;
                    }

                    if(A.get(checkLeft) == A.get(mid)){
                        count++;
                        checkLeft--;
                    }else{
                        break;
                    }
                }

                while(true){
                    if(checkRight >= A.size()){
                        break;
                    }

                    if(A.get(checkRight) == A.get(mid)){
                        count++;
                        checkRight++;
                    }else{
                        break;
                    }
                }


                break;
            }
            
                
            
        }
        return count;
    }
}
