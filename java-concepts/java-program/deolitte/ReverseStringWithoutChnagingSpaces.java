public class ReverseStringWithoutChnagingSpaces {
    public static String reverseStringWithoutChangingSpaces(String input) {
        // Convert the input string to a character array for easier manipulation
        char[] charArray = input.toCharArray();

        // Initialize two pointers
        int left = 0;
        int right = charArray.length - 1;

        // Loop until the left pointer is less than the right pointer
        while (left < right) {
            // Move the left pointer to the next non-space character
            if (Character.isSpaceChar(charArray[left])) {
                left++;
            }
            // Move the right pointer to the previous non-space character
            else if (Character.isSpaceChar(charArray[right])) {
                right--;
            }
            // If both pointers are at non-space characters, swap them
            else {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;

                // Move both pointers towards the center
                left++;
                right--;
            }
        }

        // Convert the character array back to a string and return the result
        return new String(charArray);
    }

    public static void main(String[] args) {
        // Example input
        String input = "My  name is   sam.";
        
        // Call the function and print the result
        String result = reverseStringWithoutChangingSpaces(input);
        System.out.println("Reversed String: " + result);  // Output: "mas  is eman   yM"
    }
}
