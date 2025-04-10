import java.util.Stack;

class Main {
    public static void main(String[] args) {
        System.out.println("Prefix to Postfix");
        String prefix = "/-AB*+DEF"; //postfix = AB-DE+F*/
        Stack<String> st = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperand(c)) {
                String str = Character.toString(c);
                st.push(str);
            } else { //is operator
                String str1 = st.pop();
                String str2 = st.pop();
                String str = str1 + str2 + c;
                st.push(str);
            }
        }
        String postfix = st.pop();
        System.out.println(postfix);
    }
    
    private static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}