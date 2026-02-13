public class ValidParentheses {
    public static boolean checkValidString(String s) {
        int minOpen = 0;  // Minimum number of open parentheses
        int maxOpen = 0;  // Maximum number of open parentheses

        // First pass: left to right
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen = Math.max(minOpen - 1, 0);  // Can't have negative open parentheses //// This should decrement minOpen, but not below 0
                maxOpen--;
            } else if (ch == '*') {
                minOpen = Math.max(minOpen - 1, 0);  // Treat * as empty string (like ')')
                maxOpen++;  // Treat * as '(' (like opening a parenthesis)
            }

            // If maxOpen goes below 0, it's invalid because we have too many closing parentheses
            if (maxOpen < 0) {
                return false;
            }
        }

        // After the forward pass, check if we have balanced parentheses
        return minOpen == 0;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "((**)"; // Expected output: true
        String s2 = "()()";  // Expected output: true
        String s3 = "(((**)"; // Expected output: true
        String s4 = "(()))";  // Expected output: false
        String s5 = "(((((*)(*))" // Expected output: true
        
        System.out.println(checkValidString(s1)); // true
        System.out.println(checkValidString(s2)); // true
        System.out.println(checkValidString(s3)); // true
        System.out.println(checkValidString(s4)); // false
        System.out.println(checkValidString(s5)); // true
    }
}
