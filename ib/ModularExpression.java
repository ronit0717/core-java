public class Solution {
    public int Mod(int A, int B, int C) {
        HashMap<Integer, Integer> memMap = new HashMap<>();
        return Mod (A, B, C, memMap);
    }
    
    public int Mod(int A, int B, int C, HashMap<Integer, Integer> memMap) {
        if (memMap.containsKey(B)) {
            return memMap.get(B);
        }
        long res;
        if (B == 0) {
            res =  1 % C;
        } else if (B == 1) {
            res = A % C;
        } else {
            if (B % 2 == 0) {
            	res = ( (long)( (long)(Mod(A, B/2, C, memMap) % C) * (long)(Mod(A, B/2, C, memMap) % C) ) % C);
            } else {
            	res = ( (long)( (long)(Mod(A, (B/2 + 1), C, memMap) % C) * (long)(Mod(A, B/2, C, memMap) % C) ) % C);
            }    
        }
        if (res < 0) {
            return (int)(C + res);
        }
        memMap.put(B, (int)res);
        return (int)res;
    }
}


/*

Things to take care of:

#1
int a;
int b;
int c;
a * b can be large enough to overflow
but we know, (a * b) % c will always be less than c, and c is an int the end result wont overflow

long result = ((long)a * (long)b) % c
int intResult = (int) result;

#2
(A + B) mod C = (A mod C + B mod C) mod C
(A * B) mod C = (A mod C * B mod C) mod C
(A - B) mod C = (A mod C - B mod C) mod C

For division, this is different, above approach wont work
https://www.geeksforgeeks.org/modular-division/#:~:text=Modular%20division%20is%20defined%20when,GCD%20of%20them%20is%201.

#3
-2 % 3 = -2 (as per the operator)
but in arithmetic, -2 % 3 = 1 

*/