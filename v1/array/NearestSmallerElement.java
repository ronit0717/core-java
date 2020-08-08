import java.util.ArrayList;

//Link: https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int bank[] = new int[A.size()];
        int maxPointer = -1;
        int currPointer = -1;
        
        for(int i=0; i<A.size(); i++){
            int check = A.get(i);
            
            if(maxPointer != -1){
                boolean done = false;
                currPointer = maxPointer;
                while(currPointer >= 0){
                    int num = bank[currPointer];
                    if(num < check){
                        result.add(num);
                        done = true;
                        break;
                    }else{
                        currPointer--;
                    }
                }
                
                if(!done){
                    result.add(-1);
                }
                
            }else{
                result.add(-1);
            }
            maxPointer++;
            bank[maxPointer] = check;
        }

        return result;
    }
}
