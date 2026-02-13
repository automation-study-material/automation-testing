import java.util.HashSet;

public class DuplicateFromArrayByHashSet.ajav {
   public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 2, 3,5};
        HashSet<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                System.out.println("Duplicate found: " + num);
            }
        }
    }
}
