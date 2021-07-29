/*
Iterative Approach, using two stacks. This will be faster as single pass solution
*/
class Solution {
    public String decodeString(String s) {
        
        StringBuilder sb = new StringBuilder();
        Stack<String> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int count = c - '0';
                while ( (i < s.length() - 1) &&  s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    count = count * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                countStack.push(count); //when number encountered, push number in count stack
            } else if (c == '[') {
                strStack.push(sb.toString()); //push existing string to string stack
                sb = new StringBuilder();
            } else if (c == ']') {
                String innerString = sb.toString(); //current string is the inner string
                sb = new StringBuilder(strStack.pop());
                int count = countStack.pop();
                while(count > 0) {
                    sb.append(innerString);
                    count--;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}

/*
Recursive Approach, breaking the bigger problem into smaller problem
*/

class Solution {
    public String decodeString(String s) {
        return decodeString(1, s);   
    }
    
    public String decodeString(int count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int newCount = str.charAt(i) - '0';
                while ( (i < str.length() - 1) && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                    newCount = newCount * 10 + str.charAt(i + 1) - '0';
                    i++;
                } 
                String substr = getSubstringUtil(i + 1, str);
                int substrLen = substr.length();
                sb.append(decodeString(newCount, substr));
                i += substrLen + 2;
            } else {
                sb.append(str.charAt(i));
            }
        }
        String newStr = sb.toString();
        sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(newStr);
        }
        return sb.toString();
    }

    private String getSubstringUtil(int index, String str) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                if (!stack.isEmpty()) {
                    sb.append(str.charAt(i));
                }
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ']') {
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                } else {
                    sb.append(str.charAt(i));
                }
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}