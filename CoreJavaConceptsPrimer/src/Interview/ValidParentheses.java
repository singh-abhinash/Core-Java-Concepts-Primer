package Interview;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
        // Test case 1
        String s1 = "()[]{}";
        System.out.println(isValid(s1));  // Output: true
        
        // Test case 2
        String s2 = "(]";
        System.out.println(isValid(s2));  // Output: false
        
        // Test case 3
        String s3 = "([)]";
        System.out.println(isValid(s3));  // Output: false
        
        // Test case 4
        String s4 = "{[]}";
        System.out.println(isValid(s4));  // Output: true
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If stack is empty or top doesn't match
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // In the end, stack should be empty
        return stack.isEmpty();
    }

}
