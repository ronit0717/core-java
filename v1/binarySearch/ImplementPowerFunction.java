//Link: https://www.interviewbit.com/problems/implement-power-function/

//solution not working for large integers
import java.math.BigInteger;

public class Solution {
    public int pow(int x, int n, int d) {
      
        if(n == 0){
            return 1%d;
        }

        int diff;
        if(x >= d){
            diff = x-d+1;      
        }else if(x < 0){
            diff = d+x+1;
        }else{
            diff = d-x+1;
        }
        
        System.out.println("diff: "+diff);

        int newN = n%diff;
        
        System.out.println("newN: "+newN);

        BigInteger prod = getProd(x, newN);
        
        System.out.println("prod: "+prod);

        BigInteger bigZero = new BigInteger("0");
        BigInteger bigD = new BigInteger(Integer.toString(d));
        if(prod.compareTo(bigZero) != -1){
            BigInteger result = (prod.mod(bigD));
            return result.intValue();
        }else{
            BigInteger result = (prod.mod(bigD));
            return (d + result.intValue());
        }
      
    }

    private static BigInteger getProd(int x, int n){
        BigInteger prod = new BigInteger("1");
        BigInteger bigX = new BigInteger(Integer.toString(x));
        
        int rem  = 0;
        if(n > 1){
            rem = n%2;    
        }
        
        prod = bigX;
        while(n != 1){
            n = n/2;
            prod = prod.pow(2);
        }
        
        for(int i=0; i<rem; i++){
            prod = prod.multiply(bigX);
        }

        return prod;
    }
}


/* 
Correct Solution

public class Solution 
{
    
    public int pow(int x, int n, int d) 
    {
        long ans = 1;
        if(x==0 && n==0)
        {
            if(d!=1)
                return 1;
            else
                return 0;
        }
        if(x==0)
            return 0;
        long a = x;
        int b = n;
        
        while(b>0)
        {
            if((b&1)==1)
                ans = (ans*a);
            if(ans<0)
                ans = d - (-1*x)%d;
            else
                ans = ans%d;
                
            b = b>>1;
            a = (a*a)%d;
        }
        
        return (int)ans;
    }
}


*/