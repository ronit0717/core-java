/*
TC = O(n * LogN), SC = O(1)

Explanations:
12 34 67 90, distribute among 2 students

so, possible ways of distribution
((12) and (34 + 67 +90 = 191)) , ((12 + 34 = 46), (67 + 90 = 157)), ((12 + 34 + 67 = 113), (90))

Max of each possibility => 191, 157, 113
Min of (max of each possibilities) = 113 (answer)

Algo:
the answer range can be between min = 12 and max = 12 +34 + 67 + 90 = 203

now, do binary approach to find mid
This mid is say the maximum pages that can be allocated to a student
Find the number of students, 
    if number of students become more than total number of students,
    this cannot be a answer. Hence the mid needs to be increased

    else, it can be possible answer and we decrease mid such that we get a better result
*/
public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if (A.size() < B) {
            return -1;
        }
        int min = A.get(0);
        int max = 0;
        for (Integer page : A) {
            max += page;
        }
        int candidatePageCount = -1;

        while (min <= max) {
            int maxPageCount = (min + max) / 2; //max page that get allocated (say)
            int count = 1;
            int currPageCount = 0;
            boolean allocationPossible = true;
            for (Integer pages : A) {
                if (pages > maxPageCount) {
                    allocationPossible = false;
                    break;
                }
                if ((maxPageCount - currPageCount) < pages) {
                    count++;
                    currPageCount = 0;
                }
                currPageCount += pages;
            }
            if (allocationPossible && count <= B) {
                candidatePageCount = maxPageCount; //this is a possible solution
                max = maxPageCount - 1; //Decrease maxPageCount ie shift left, as we want the minimum possible answer
            } else { //increase maxPageCount ie shift right
                min = maxPageCount + 1;
            }
        }
        return candidatePageCount;
    }
}
