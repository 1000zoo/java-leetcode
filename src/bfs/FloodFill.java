//2023-12-06
//https://leetcode.com/problems/flood-fill/

package bfs;

import java.util.*;

public class FloodFill {

    // Runtime: 2ms (15.05%), Memory: 43.97MB (61.21%)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int originColor = image[sr][sc];

        queue.add(new int[] {sr, sc});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            image[curr[0]][curr[1]] = color;

            for (int[] dir : dirs) {
                int[] next = new int[] {curr[0] + dir[0], curr[1] + dir[1]};

                if (!isWithinBoundary(next, image)) continue;
                if (image[next[0]][next[1]] != originColor) continue;
                if (visited[next[0]][next[1]]) continue;

                queue.add(next);
            }
        }

        return image;
    }

    private boolean isWithinBoundary(int[] curr, int[][] image) {
        return 0 <= curr[0] && curr[0] < image.length && 0 <= curr[1] && curr[1] < image[0].length;
    }
}
