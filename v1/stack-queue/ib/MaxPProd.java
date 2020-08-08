//code not 100% passed... need to further optimize

import java.util.ArrayList;

public class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        Stack<Integer> leftStack = new Stack<Integer>();
        Stack<Integer> rightStack = new Stack<Integer>();

        long prodMax = -1;

        int leftSpecialArray[] = new int[A.size()];
        int rightSpecialArray[] = new int[A.size()];

        for(int i=0; i< A.size(); i++){
            int i2 = A.size() - i - 1;
            int currLeft = A.get(i);
            int currRight = A.get(i2);

            int leftSpecial = 0;
            int rightSpecial = 0;

            while(!leftStack.empty()){
                int valIndex = leftStack.peek();
                int val = A.get(valIndex);

                if(val > currLeft){
                    leftSpecial = valIndex;
                    break;
                }else{
                    leftStack.pop();    
                }
            }

            while(!rightStack.empty()){
                int valIndex = rightStack.peek();
                int val = A.get(valIndex);

                if(val > currRight){
                    rightSpecial = valIndex;
                    break;
                }else{
                    rightStack.pop();    
                }
            }

            leftStack.push(i);
            rightStack.push(i2);
            leftSpecialArray[i] = leftSpecial;
            rightSpecialArray[i2] = rightSpecial;
        }
        
        for(int i=0; i<A.size(); i++){
            long currProd = rightSpecialArray[i] * leftSpecialArray[i];

            if(currProd > prodMax){
                prodMax = currProd;
            }
        }

        int result = (int)(prodMax%1000000007);
        return result;

    }
}
