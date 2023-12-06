//2023-12-06
//https://leetcode.com/problems/find-if-path-exists-in-graph/

package dfs;

import java.util.*;

public class FindIfPathExistsInGraph {

    private Map<Integer, List<Integer>> graph;

    //시간초과
    //bfs, graph 코드 참고
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return dfs(source, destination, new HashSet<>());
    }

    private boolean dfs(int curr, int destination, Set<Integer> visited) {
        if (curr == destination) {
            return true;
        }

        boolean answer = false;

        for (int next : graph.get(curr)) {
            if (visited.contains(next)) continue;
            visited.add(next);
            answer = dfs(next, destination, visited) || answer;
            visited.remove(next);
        }

        return answer;
    }
}
