package ib;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        ArrayList<Integer> output = new ArrayList<Integer>();

        for(int i=0; i < A.size(); i++){
            if(i == 0){
                output.add(A.get(i));
            }else{
                int a = A.get(i);
                boolean done = false;
                
                for(int j=0; j<output.size(); j++){
                    int b = output.get(j);
                    int comp = significantCompare(a, b);
                    //System.out.println("Comp -->"+comp);

                    if(! (comp == -1)){
                        output.add(j, a);
                        done = true;
                        break;
                    }
                }

                if(!done){
                    output.add(a);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean nonZeroEncountered = false;
        for(int i =0; i < output.size(); i++){
            int n = output.get(i);
            if(n == 0 && !nonZeroEncountered){
                continue;
            }
            
            if(n != 0){
                nonZeroEncountered = true;
            }
            sb.append(output.get(i));
            //sb.append(",");
        }
        
        if(!nonZeroEncountered){
            return "0";
        }

        return sb.toString();
    }
    
    private static int significantCompare(int a, int b){
        //System.out.println("a --> "+a + " : b -->"+b);
        
        StringBuilder sb = new StringBuilder();
        
        //combo1
        sb.append(a);
        sb.append(b);
        long comb1 = Long.valueOf(sb.toString());
        
        //combo2
        sb = new StringBuilder();
        sb.append(b);
        sb.append(a);
        long comb2 = Long.valueOf(sb.toString());
        
        if(comb1 > comb2){
            return 1;
        }else if(comb1 < comb2){
            return -1;
        }else{
            return 0;
        }
    }
}