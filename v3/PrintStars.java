public class PrintStars{

     public static void main(String []args){
        printStar(10);
     }
     
     public static void printStar(int lineCount) {
         if (lineCount <= 1) {
             return;
         }
         int n = 2 * lineCount - 1;
         for (int i = 0; i < lineCount; i++) {
             int printCount = 0;
             int printIndex = n / 2 - i;
             int j = 0;
             while (printCount <= i) {
                 if (j == printIndex) {
                     System.out.print("X");
                     printCount++;
                     printIndex += 2;
                 } else {
                     System.out.print(" ");
                 }
                 j++;
             }
             System.out.print("\n");
         }
     }
}

/*
Output:

         X
        X X
       X X X
      X X X X
     X X X X X
    X X X X X X
   X X X X X X X
  X X X X X X X X
 X X X X X X X X X
X X X X X X X X X X

*/