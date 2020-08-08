package ib;

//Link: https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/

import java.util.ArrayList;

public class NumOfLenAndLessThan {
    private static int size = 0;
    public int solve(ArrayList<Integer> A, int B, int C) {
        int size = A.size();

        int end = size-1;
        int start = 0;

        int num[] = new int[size];
        int choice[] = new int[size];
        int numVal;


        int totalChoice = 0;
        for(int i=0; i<size; i++){
            if(i == 0){
                totalChoice = choice[0];
            }else{
                totalChoice *= choice[i];
            }
        }
        return totalChoice;
    }

    private static int getVal(int num[]){
        int numVal = 0;
        int q = 1;
        for(int i=(size-1) ; i>=0; i--){
            numVal += q*num[i];
        }

        return numVal;
    }
}