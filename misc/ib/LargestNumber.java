package ib;

import java.util.*;

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
        }
        
        if(!nonZeroEncountered){
            return "0";
        }

        return sb.toString();
    }
    
    private static int significantCompare(int a, int b){
        ArrayList<Integer> aList = getNumArray(a);
        ArrayList<Integer> bList = getNumArray(b);

        int aSizeBig = 0;

        int size = 0;
        if(aList.size() < bList.size()){
            size = aList.size();
            aSizeBig = -1;
        }else if(aList.size() > bList.size()){
            size = bList.size();
            aSizeBig = 1;
        }else{
            size = aList.size();
        }

        int count = 0;
        while(count < size){
            if(aList.get(count) > bList.get(count)){
                return 1;
            }else if(aList.get(count) < bList.get(count)){
                return -1;
            }
            count++;
        }

        if(aSizeBig == 1){
            int curr = bList.get(count-1);
            int next = aList.get(count);

            if(next > curr){
                return 1;
            }else if(next < curr){
                return -1;
            }else{
                return 1;
            }
        }else if(aSizeBig == -1){
            int curr = aList.get(count-1);
            int next = bList.get(count);

            if(next > curr){
                return -1;
            }else if(next < curr){
                return 1;
            }else{
                return -1;
            }
        }

        return 0;
    }

    private static ArrayList<Integer> getNumArray(int num){
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(num/10 != 0){
            int n = num%10;
            result.add(0, n);    
            num = num/10;
        }

        result.add(0, num);
        return result;
    }
}


/* 
wrong result for this case:
782, 240, 409, 678, 940, 502, 113, 686, 6, 825, 366, 686, 877, 357, 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363, 298, 470, 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905
*/