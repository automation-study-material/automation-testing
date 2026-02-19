import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1, 3};

        int[] sorted = Arrays.stream(arr)
                             .sorted()
                             .toArray();

        System.out.println(Arrays.toString(sorted));
    }
}
