//https://leetcode.com/problems/array-partition/
//2022-11-23

package greedy;

import java.util.*;

public class ArrayPartition {

    //Time : O(NLogN), Space: O(1)
    //Runtime: 21 ms, faster than 55.87% of Java online submissions for Array Partition.
    //Memory Usage: 53.8 MB, less than 58.54% of Java online submissions for Array Partition.
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length; i += 2) {
            answer += nums[i];
        }
        return answer;
    }
}
