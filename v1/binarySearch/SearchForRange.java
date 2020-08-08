import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
       int start = 0;
       int size = a.size();
       int end = size-1;

       int pointStart = -1;
       int pointEnd = -1;

       ArrayList<Integer> result = new ArrayList<Integer>();

       //search for range start
       while(start <= end){
            int mid = start + (end-start)/2;
            if(mid == 0 && a.get(mid) == b){
                pointStart = mid;
                break;
            }

            if(a.get(mid) == b){
                if(a.get(mid-1) < b){
                    pointStart = mid;
                    break;
                }else{
                    //move left
                    end =  mid-1;
                }
            }else if(a.get(mid) < b){
                //move right
                start = mid+1;
            }else{
                //move left
                end = mid-1;
            }
       }

       if(pointStart != -1){
           //search for pointEnd
           start = pointStart;
           end = size-1;

           if(start == end){
               pointEnd = pointStart;
           }else{
               while(start <= end){
                    int mid = start + (end-start)/2;
                    if(mid == (size-1) && a.get(mid) == b){
                        pointEnd = mid;
                        break;
                    }
        
                    if(a.get(mid) == b){
                        if(a.get(mid+1) > b){
                            pointEnd = mid;
                            break;
                        }else{
                            //move right
                            start =  mid+1;
                        }
                    }else if(a.get(mid) < b){
                        //move right
                        start = mid+1;
                    }else{
                        //move left
                        end = mid-1;
                    }
               }
           }
       }

       result.add(pointStart);
       result.add(pointEnd);

       return result;
    }
}
