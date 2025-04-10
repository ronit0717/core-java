import java.util.Stack;

class Main {
    public static void main(String[] args) {
        System.out.println("Prefix to Infix");
        String prefix = "*+PQ-MN"; //infix = ((P+Q)*(M-N))
        Stack<String> st = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperand(c)) {
                String str = Character.toString(c);
                st.push(str);
            } else { //is operator
                String str1 = st.pop();
                String str2 = st.pop();
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