package Stack;

import java.util.Stack;

public class ValidParentheses {
    public  static  boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topCh = stack.pop();
                if (ch == '}' && topCh != '{') {
                    return false;
                }
                if (ch == ']' && topCh != '[') {
                    return false;
                }
                if (ch == ')' && topCh != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{"));
    }
}
