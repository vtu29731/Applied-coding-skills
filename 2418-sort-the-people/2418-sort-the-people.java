import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        // Map height -> name in reverse (descending) order
        Map<Integer, String> map = new TreeMap<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        String[] result = new String[n];
        int index = 0;
        for (String name : map.values()) {
            result[index++] = name;
        }

        return result;
    }
}