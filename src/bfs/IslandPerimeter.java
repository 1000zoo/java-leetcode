//2023-12-06
//https://leetcode.com/problems/island-perimeter/

package bfs;

import java.util.*;

public class IslandPerimeter {

    // Runtime: 87ms (5.04%), Memory: 45.55MB (5.20%)
    public int islandPerimeter(int[][] grid) {
        int answer = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> queueSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    break;
                }
            }
            if (!queue.isEmpty()) break;
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited.add(arrToString(curr));

            for (int[] dir : dirs) {
                int[] next = new int[] {curr[0] + dir[0], curr[1] + dir[1]};

                if (!isWithinBoundary(next, grid)) {
                    answer++;
                    continue;
                }
                if (grid[next[0]][next[1]] == 0) {
                    answer++;
                    continue;
                }
                if (visited.contains(arrToString(next))) continue;
                if (queueSet.contains(arrToString(next))) continue;
                queue.add(next);
                queueSet.add(arrToString(next));
            }
        }

        return answer;
    }

    private boolean isWithinBoundary(int[] curr, int[][] grid) {
        return 0 <= curr[0] && curr[0] < grid.length && 0 <= curr[1] && curr[1] < grid[0].length;
    }

    private String arrToString(int[] arr) {
        return arr[0] + "," + arr[1];
    }
}
