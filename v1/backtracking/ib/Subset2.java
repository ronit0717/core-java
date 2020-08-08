import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = subsets(a, 0);

        result.add(new ArrayList<Integer>());

        //Collections.sort(result);
        return result;
    }

    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a, int startIndex){
        if(startIndex >= a.size()){
            return new ArrayList<ArrayList<Integer>>();
        }

        ArrayList<ArrayList<Integer>> intResult = subsets(a, startIndex+1);

        ArrayList<ArrayList<Integer>> finResult = new ArrayList<ArrayList<Integer>>();

        int currVal = a.get(startIndex);

        for(int i=0; i < intResult.size(); i++){
            ArrayList<Integer> curr = intResult.get(i);
            finResult.add(curr);

            curr.add(0, currVal);
            finResult.add(curr);
        }

        ArrayList<Integer> currList = new ArrayList<Integer>();
        currList.add(currVal);
        finResult.add(currList);

        return finResult;
    }
}