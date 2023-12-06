//2023-12-06
//https://leetcode.com/problems/find-if-path-exists-in-graph/

package bfs;

import java.util.*;

public class FindIfPathExistsInGraph {

    // Runtime: 96ms (59.77%), Memory: 147.78MB (52.50%)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.add(source);
        set.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (!set.contains(next)) {
                    if (next == destination) return true;
                    queue.add(next);
                    set.add(next);
                }
            }
        }

        return false;
    }
}
