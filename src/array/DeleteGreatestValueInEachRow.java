//https://leetcode.com/problems/delete-greatest-value-in-each-row/description/?submissionId=1089765803
//2023-11-02

package array;

import java.util.*;

public class DeleteGreatestValueInEachRow {

    // Array 풀이
    // Runtime: 4ms (Beats 83.25%)
    // Memory: 42.93MB (Beats 78.92%)
    public int solvedWithArraySort(int[][] grid) {
        int answer = 0;

        for (int[] row : grid) {
            Arrays.sort(row);
        }

        for (int i = grid[0].length - 1; i >= 0; i--) {
            int max = -1;
            for (int[] row : grid) {
                max = Math.max(row[i], max);
            }
            answer += max;
        }

        return answer;
    }

    // priority queue 풀이
    // Runtime: 14ms (Beats 5.32%)
    // Memory: 43.32MB (Beats 32.71%)
    public int solvedWithPriorityQueue(int[][] grid) {
        List<Queue<Integer>> list = toList(grid);
        int length = grid[0].length;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            int max = -1;
            for (Queue<Integer> pq : list) {
                max = Math.max(pq.poll(), max);
            }
            answer += max;
        }

        return answer;
    }

    private List<Queue<Integer>> toList(int[][] grid) {
        List<Queue<Integer>> list = new ArrayList<>();

        for (int[] row : grid) {
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : row) {
                pq.add(i);
            }
            list.add(pq);
        }

        return list;
    }
}
