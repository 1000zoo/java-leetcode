//https://leetcode.com/problems/maximum-score-from-removing-stones/
//2022-11-09

package heap;

import java.util.*;

public class MaximumScoreFromRemovingStones {

    //Runtime: 13 ms, faster than 67.84% of Java online submissions for Maximum Score From Removing Stones.
    //Memory Usage: 41.2 MB, less than 66.67% of Java online submissions for Maximum Score From Removing Stones.
    public int maximumScore(int a, int b, int c) {

        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);

        if (arr[0] + arr[1] <= arr[2]) {
            return arr[0] + arr[1];
        }
        if (arr[1] == arr[2]) {
            return arr[1] + arr[0] / 2;
        }
        int count = 0;
        while (arr[0] > 0) {
            arr[0]--;
            arr[2]--;
            count++;
            Arrays.sort(arr);
        }
        while (arr[1] > 0) {
            arr[1]--;
            arr[2]--;
            count++;
        }

        return count;
    }
}
