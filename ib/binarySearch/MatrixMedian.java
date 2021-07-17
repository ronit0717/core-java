/*
Basic logic is to find a number num such that num will definitely have 
(N x M) / 2 numbers less than or equal to num

TC = O(logbase2(2 ^ 32)) * O (N * logbase2(M)) =  O(32 * n * log(m)) = O (nlogm)
SC = O(1)

*/

public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int min = 1;
        int max = Integer.MAX_VALUE;
        int num = (A.size() * A.get(0).size()) / 2; //N x M
        int candidate = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            int count = getCountLessThanEqualTo(A, mid);
            if (count > num) { //move left
                candidate = mid; //this satifies the condition, hence this becomes a candidate for the answer
                max = mid - 1; //now we want to check any number in the left range which also satisfies the condition
            } else {
                //this is definitely not a candidate
                min = mid + 1;
            }
        } 
        return candidate;
    }

    private int getCountLessThanEqualTo(ArrayList<ArrayList<Integer>> A, int num) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            int min = 0; //minIndex
            int max = A.get(i).size() - 1; //maxIndex
            int countCandidate = 0;
            while (min <= max) {
                int mid = (max + min) / 2;
                int midNum = A.get(i).get(mid);
                if (midNum <= num) {
                    min = mid + 1;
                    countCandidate = min; //there will be min numbers which are less than or equal to midNum
                    
                    //this midNum satisfies the condition, hence this is the countCandidatebut 
                    //now we want to check if there is any number to the right of midNum which also satisfies the condition
                } else {
                    max = mid - 1;
                }
            }
            count += countCandidate;
        }
        return count;
    }
}
