import java.util.Stack;

class Main {
    public static void main(String[] args) {
        System.out.println("Infix to Postfix");
        String infix = "(p+q)*(m-n)"; //postfix = pq+mn-*
        //String infix = "a+b*(c^d-e)^(f+g*h)-i"; //postfix = abcd^e-fgh*+^*+i-
        Stack<Character> st = new Stack<>();
        String postFix = "";
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while(!st.isEmpty()) {
                    char pop = st.pop();
                    if (pop == '(') {
                        break;
                    }
                    postFix += pop;
                }
            } else if (isOperand(c)) {
                postFix += c;
            } else if (isOperator(c)) {
                int p1 = getOperatorPriority(c);
                while(!st.isEmpty() && getOperatorPriority(st.peek()) >= p1) {
                    postFix += st.pop();
                }
                st.push(c);
            }
            
        }
        while(!st.isEmpty()) {
            postFix += st.pop();
        }
        System.out.println(postFix);
    }
    
    private static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    
    private static boolean isOperator(char c) {
        return (c == '^' || c == '*' || c == '/' ||  c == '+' || c == '-');
    }
    
    private static int getOperatorPriority(char c) {
        if (c == '^') {
             return 2;
        } else if (c == '*' || c == '/') {
            return 1;
        } else if (c == '+' || c == '-') {
            return 0;
        }
        return -1;
    }
}