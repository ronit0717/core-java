import java.util.Stack;

class Main {
    public static void main(String[] args) {
        System.out.println("Postfix to Infix");
        String postfix = "AB-DE+F*/"; //infix = ((A-B)/((D+E)*F))
        Stack<String> st = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperand(c)) {
                String str = Character.toString(c);
                st.push(str);
            } else { //is operator
                String str2 = st.pop();
                String str1 = st.pop();
                String str = "(" + str1 + c + str2 + ")";
                st.push(str);
            }
        }
        String infix = st.pop();
        System.out.println(infix);
    }
    
    private static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}