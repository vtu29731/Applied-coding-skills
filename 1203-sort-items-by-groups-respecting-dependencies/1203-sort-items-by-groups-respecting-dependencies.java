import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Assign a unique group to each ungrouped item
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        int totalGroups = m;

        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < totalGroups; i++) {
            groupGraph.add(new ArrayList<>());
        }

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[totalGroups];

        // Build item and group dependency graphs
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;

                if (group[prev] != group[i]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        // Topologically sort items
        List<Integer> sortedItems = topoSort(itemGraph, itemIndegree, n);

        if (sortedItems.size() != n) {
            return new int[0];
        }

        // Topologically sort groups
        List<Integer> sortedGroups = topoSort(groupGraph, groupIndegree, totalGroups);

        if (sortedGroups.size() != totalGroups) {
            return new int[0];
        }

        // Collect items group by group
        List<List<Integer>> groupedItems = new ArrayList<>();

        for (int i = 0; i < totalGroups; i++) {
            groupedItems.add(new ArrayList<>());
        }

        for (int item : sortedItems) {
            groupedItems.get(group[item]).add(item);
        }

        List<Integer> result = new ArrayList<>();

        for (int g : sortedGroups) {
            result.addAll(groupedItems.get(g));
        }

        // Convert to array
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree, int size) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int next : graph.get(node)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return order;
    }
}