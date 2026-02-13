// Custom Exception Class
public class SpecialCharacterFoundException extends Exception {
    // Constructor to create the exception with a message
    public SpecialCharacterFoundException(String message) {
        super(message);  // Call the parent Exception constructor
    }
}


public class SpecialCharacterChecker {
    // Method to check if a string contains any special character
    public static void checkForSpecialCharacter(String str) throws SpecialCharacterFoundException {
        // Define a regular expression to check for special characters
        String specialChars = "[!@#$%^&*(),.?\":{}|<>]";  // List of special characters
        
        // Check if the string contains at least one special character
        if (str.matches(".*[" + specialChars + "].*")) {
            // If a special character is found, throw the custom exception with a detailed message
            throw new SpecialCharacterFoundException("The string \"" + str + "\" contains a special character. Please remove it.");
        }
    }

    public static void main(String[] args) {
        // Test string (this string contains a special character)
        String input = "HelloWorld!";  // This string has a special character

        try {
            // Call the method to check for special characters
            checkForSpecialCharacter(input);
            System.out.println("The string is valid (no special characters).");
        } catch (SpecialCharacterFoundException e) {
            // Handle the exception if the string contains special characters
            System.out.println("Exception: " + e.getMessage());
        }

        // Test another string (this one does not contain special characters)
        String input2 = "HelloWorld123";  // This string has no special characters

        try {
            // Call the method to check for special characters
            checkForSpecialCharacter(input2);
            System.out.println("The string is valid (no special characters).");
        } catch (SpecialCharacterFoundException e) {
            // Handle the exception if the string contains special characters
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

Exception Msg if Occure :
Exception: The string "HelloWorld!" contains a special character. Please remove it.
