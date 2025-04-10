import java.util.Stack;

class Main {
    public static void main(String[] args) {
        System.out.println("Infix to Prefix");
        //String infix = "A*B+C/D"; //postfix = +*AB/CD
        //String infix = "(a+b)* (c+d)"; //postfix = *+ab+cd
        String infix = "x^y/ (5z)+2"; //postfix = +/^xy5z2
        
        //Reverse
        String reverse = "";
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (c == '(') {
                reverse += ')';
            } else if (c == ')') {
                reverse += '(';
            } else {
                reverse += c;   
            }
        }
        String reversePostfix = getControlledPostfixFromInfix(reverse);
        String postFix = "";
        for (int i = reversePostfix.length() - 1; i >= 0; i--) {
            postFix += reversePostfix.charAt(i);
        }
        System.out.println(postFix);
    }
    
    private static String getControlledPostfixFromInfix(String infix) {
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
                while(!st.isEmpty() && getOperatorPriority(st.peek()) > p1) { //only greater than. This is why its called controlled
                    postFix += st.pop();
                }
                st.push(c);
            }
            
        }
        while(!st.isEmpty()) {
            postFix += st.pop();
        }
        return postFix;
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