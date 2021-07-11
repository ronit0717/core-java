public class HelloWorld{
    
     //private static final String ALPHABET = "0123456789ABCDEF";
     //private static final int BASE = 16;
     
     private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/";
     private static final int BASE = 64;

     public static void main(String []args){
        System.out.println(encode(63));
     }
     
     private static String encode(int num) {
         StringBuilder sb = new StringBuilder();
         
         while (num >= BASE) {
            int index = num % BASE;
            sb.append(ALPHABET.charAt(index));
            num /= BASE;
         }
         sb.append(ALPHABET.charAt(num));
         return sb.reverse().toString();
     }
}