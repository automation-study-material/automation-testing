import java.util.HashSet;

public class FindDuplicates {
    public static void main(String[] args) {
        String str = "programming";
        HashSet<Character> seen = new HashSet<>();
        System.out.println("Duplicate characters:");
        for (char c : str.toCharArray()) {
            if (!seen.add(c)) {
                System.out.println(c);
            }
        }
    }
}
