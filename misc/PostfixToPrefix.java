import java.util.Stack;

class Main {
    public static void main(String[] args) {
        System.out.println("Postfix to Prefix");
        String postfix = "AB-DE+F*/"; //prefix = /-AB*+DEF
        Stack<String> st = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperand(c)) {
                String str = Character.toString(c);
                st.push(str);
            } else { //is operator
                String str2 = st.pop();
                String str1 = st.pop();
                String str = c + str1 + str2;
                st.push(str);
            }
        }
        String prefix = st.pop();
        System.out.println(prefix);
    }
    
    private static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}