//https://leetcode.com/problems/maximum-units-on-a-truck/
//2022-11-23

package greedy;

import java.util.*;

public class MaximumUnitOnTruck {

    //Time : O(NLogN), Space: O(1)
    //Runtime: 12 ms, faster than 80.50% of Java online submissions for Maximum Units on a Truck.
    //Memory Usage: 50.7 MB, less than 57.27% of Java online submissions for Maximum Units on a Truck.
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> Integer.compare(b2[1], b1[1]));
        int answer = 0;

        for (int[] boxType : boxTypes) {
            if (truckSize == 0) break;
            answer += Math.min(truckSize, boxType[0]) * boxType[1];
            truckSize = Math.max(0, truckSize - boxType[0]);
        }

        return answer;
    }
}
