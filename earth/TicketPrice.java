/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TicketPrice {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
        
        Scanner sc = new Scanner(System.in);
        
        int rows = sc.nextInt();
        int fans = sc.nextInt();
        
        int seats[] = new int[rows];
        
        for(int i=0; i < rows; i++){
            seats[i] = sc.nextInt();
        }

        int price = 0; 

        for(int i=0; i< fans; i++){
            Arrays.sort(seats);
            price += seats[rows-1];
            seats[rows-1] = seats[rows-1] -1;
        }

        System.out.println("Max Price-->"+price);

        sc.close();

        // Write your code here

    }
}
