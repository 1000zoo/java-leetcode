// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

package heap;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElements {

    /*
    * Runtime 72 ms Beats 11.79%
    * */
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((l1, l2) -> l1[0] - l2[0]);
        int currMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int currNum = nums.get(i).get(0);
            queue.add(new int[] {currNum, i, 0});
            currMax = Math.max(currNum, currMax);
        }

        int[] answer = {Integer.MIN_VALUE / 2, Integer.MAX_VALUE / 2};

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 0: curr num, 1: i, 2: j
            int currMin = current[0], i = current[1], j = current[2];
            if (currMax - currMin < answer[1] - answer[0]) {
                answer = new int[]{currMin, currMax};
            }
            if (j + 1 < nums.get(i).size()) {
                queue.add(new int[] {nums.get(i).get(j + 1), i, j + 1});
                currMax = Math.max(currMax, nums.get(i).get(j + 1));
            } else {
                break;
            }
        }

        return answer;
    }
}