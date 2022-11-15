//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
//2022-11-15

package heap;

import java.util.*;

public class KthSmallestElementInSortedMatrix {

    //Runtime: 26 ms, faster than 53.99% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
    //Memory Usage: 47 MB, less than 95.53% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int[] row : matrix) {
            for (int col : row) {
                pq.offer(col);
            }
        }
        while (k-- > 1) pq.poll();
        return pq.poll();
    }
}
