//Problem Statement: https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/

import java.io.*;
import java.util.Scanner;

public class SpiralPrint{

    public static void main(String[] args){
        System.out.println("Enter Dimension nXm");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Row
        int m = sc.nextInt(); //Column

        int arr[][] = new int[n][m];

        for(int row = 0; row < n; row++){
            for(int col=0; col < m; col++){
                System.out.println("Enter Element ("+row+","+col+")");
                arr[row][col] = sc.nextInt();
            }
        }

        printArray(arr, n, m);

        spiralPrintMatrix(arr, n, m);
    }

    private static void spiralPrintMatrix(int[][] arr, int n, int m){
        int maxRight = m-1;
        int maxDown = n-1;
        int maxLeft = 0;
        int maxTop = 1;

        int currRow = 0;
        int currCol = 0;

        String direction = "right";

        System.out.print("\nSpriral Print :");
        for(int i=0; i< n*m; i++){
            System.out.print(" "+arr[currRow][currCol]);
            
            if(direction.equals("right")){
                if(currCol == maxRight){
                    maxRight--;
                    direction = "down";
                    currRow++;
                }else{
                    currCol++;
                }
                
            }else if(direction.equals("down")){
                if(currRow == maxDown){
                    maxDown--;
                    direction = "left";
                    currCol--;
                }else{
                    currRow++;
                }
                
            }else if(direction.equals("left")){
                if(currCol == maxLeft){
                    maxLeft++;
                    direction = "up";
                    currRow--;
                }else{
                    currCol--;
                }
                
            }else{
                if(currRow == maxTop){
                    maxTop++;
                    direction = "right";
                    currCol++;
                }else{
                    currRow--;
                }
                
            }
        }
        System.out.println("\n");
    }

    private static void printArray(int[][] arr, int n, int m){
        System.out.print("Printing Two Dimensional Array");
        for(int row = 0; row < n; row++){
            System.out.print("\n");
            for(int col=0; col < m; col++){
                System.out.print("\t"+arr[row][col]);
            }
        }
        System.out.print("\n");

    }

}