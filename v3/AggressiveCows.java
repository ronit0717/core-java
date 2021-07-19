//Link: https://www.spoj.com/problems/AGGRCOW/

/*
TC= N * LogN
SC = O(1)
*/

import java.util.Scanner;
import java.lang.Math;

public class HelloWorld {

	public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int t = 0; t < testCount; t++) {
            int N = sc.nextInt(); //number of stalls
            int C = sc.nextInt(); //number of cows
            
            int[] stallPos = new int[N];
            for (int i = 0; i < N; i++) {
                stallPos[i] = sc.nextInt();
            }
            int result = aggressiveCowUtil(C, N, stallPos);
            System.out.println("Result = " + result);
        }
        sc.close();
     }
	
	private static int aggressiveCowUtil(int C, int N, int[] pos) {
         Arrays.sort(pos);
         
         //minDist will be between the first two elements, and max distance will be between
         //first and the last element
         int minDist = pos[1] - pos[0]; 
         int maxDist = pos[N - 1] - pos[0];
         
         int resultCandidate = 0; //will store the result

         while (minDist <= maxDist) {
             int dist = (maxDist + minDist) / 2;
             
             if (!canPlaceCows(pos, dist, C, N)) {
                //cows could not be placed with distance 'dist', hence we now try to minimize
                //the distance 'dist'
                 maxDist = dist - 1;
             } else {
                 resultCandidate = dist; //as we can place cow with this distance 'dist', this becomes
                                         //a candidate for our result
                 
                 //now we would try to find a better (maximise) distance 'dist'
                 minDist = dist + 1;
             }
         }
         return resultCandidate;
     }

     private static boolean canPlaceCows(int[] pos, int dist, int C, int N) {
         int count;
         int k = 0; //cow placed here at 0th position as a greedy way to fit maximum number of cows, the
         //first cow will definitely be eligible to be here in 0th position
         
         count = 1; //initialized to 1 as first cow placed here at 0th position
         for (int j = i + 1; j < N; j++) {
             if ((pos[j] - pos[k]) >= dist) {
                //we can place the cow here in jth position
                 count++;
                 k = j;
                 if (count == C) {
                     return true;
                 }
             }
         }
         return false;
     }
}