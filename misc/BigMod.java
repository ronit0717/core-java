import java.math.BigInteger;

/**
 * Created by kejiawu on 2017/10/31.
 */
public class BigMod {
    public static void main(String[] args){
        BigInteger bA = new BigInteger("2147483647");
        BigInteger bB = new BigInteger("2147483647");
        BigInteger bM = new BigInteger("1000000007");
        System.out.println("BigInteger: A mod M = " + bA.mod(bM));
        System.out.println("BigInteger: (A mod M) * (B mod M) = " + bA.mod(bM).multiply( bB.mod(bM)) );
        BigInteger bRes = (bA.mod(bM).multiply( bB.mod(bM)) ).mod(bM);
        System.out.println("BigInteger: ((A mod M) * (B mod M)) mod M= " + bRes);

        long A = Integer.MAX_VALUE;
        long B = Integer.MAX_VALUE;
        int M = 1000000007;
        System.out.println("A % M = " + A % M);
        System.out.println("((A % M) * (B % M)) = " + ((A % M) * (B % M)));
        long res = ((A % M) * (B % M)) % M;
        System.out.println("((A % M) * (B % M)) % M = " + res);


    }
}