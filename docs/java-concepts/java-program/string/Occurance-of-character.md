import java.util.HashMap;
import java.util.Map;

String input = "programming";
Map<Character, Integer> map = new HashMap<>();

for (int i = 0; i < input.length(); i++) {
    char c = input.charAt(i);
    map.put(c, map.getOrDefault(c, 0) + 1);
}

System.out.println(map);
