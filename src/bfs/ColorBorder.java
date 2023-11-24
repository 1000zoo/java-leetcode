package bfs;

import java.util.*;

public class ColorBorder {

    //Runtime: 64ms Beats 6.37%
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int[][] answer = new int[grid.length][grid[0].length];
        copy(answer, grid);
        bfs(grid, answer, row, col, color);
        return answer;
    }

    private void bfs(int[][] grid, int[][] answer, int row, int col, int color) {
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] curr = new int[] {row, col};
        int originColor = answer[curr[0]][curr[1]];
        queue.add(curr);

        while (!queue.isEmpty()) {
            curr = queue.poll();
            addSet(visited, curr);
            boolean isBorder = false;

            for (int[] dir : dirs) {
                int[] next = new int[] {curr[0] + dir[0], curr[1] + dir[1]};
                if (contains(visited, next)) continue;
                if (!isWithinBoundary(answer, next)) continue;
                if (isBorder(grid, next, originColor)) {
                    isBorder = true;
                    continue;
                }
                queue.add(next);
            }

            if (grid[curr[0]][curr[1]] == originColor && (isBorder || isBoundaryOfGrid(answer, curr))) {
                answer[curr[0]][curr[1]] = color;
            }
        }
    }

    private void addSet(Set<String> set, int[] arr) {
        set.add(arrayToString(arr));
    }

    private boolean contains(Set<String> set, int[] arr) {
        return set.contains(arrayToString(arr));
    }

    private boolean isBorder(int[][] grid, int[] next, int originColor) {
        return grid[next[0]][next[1]] != originColor;
    }

    private boolean isBoundaryOfGrid(int[][] answer, int[] curr) {
        return curr[0] == 0 || curr[1] == 0 || curr[0] == answer.length - 1 || curr[1] == answer[0].length - 1;
    }

    private boolean isWithinBoundary(int[][] answer, int[] curr) {
        return 0 <= curr[0] && curr[0] < answer.length && 0 <= curr[1] && curr[1] < answer[0].length;
    }

    private String arrayToString(int[] array) {
        return "" + array[0] + "," + array[1];
    }

    private void copy(int[][] answer, int[][] grid) {
        for (int i = 0; i < answer.length; i++) {
            System.arraycopy(grid[i], 0, answer[i], 0, answer[0].length);
        }
    }
}
