//https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
//2022-11-28

package greedy;

import java.util.*;

public class MinimumSubsequence {

    //Runtime: 8 ms, faster than 48.08% of Java online submissions for Minimum Subsequence in Non-Increasing Order.
    //Memory Usage: 42.4 MB, less than 90.93% of Java online submissions for Minimum Subsequence in Non-Increasing Order.
    public List<Integer> minSubsequence(int[] nums) {
        Integer[] temp = new Integer[nums.length];
        for (int i = 0 ; i < nums.length; i++) temp[i] = nums[i];
        Arrays.sort(temp, Collections.reverseOrder());
        List<Integer> answer = new ArrayList<>();
        int totalSum = 0;
        int currSum = 0;
        for (int num : temp) totalSum += num;
        for (int num : temp) {
            currSum += num;
            totalSum -= num;
            answer.add(num);
            if (currSum > totalSum) break;
        }
        return answer;
    }
}
