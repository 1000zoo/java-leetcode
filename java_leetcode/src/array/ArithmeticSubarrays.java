//https://leetcode.com/problems/arithmetic-subarrays/submissions/885064491/
//2023-01-25

package array;

import java.util.*;

public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            answer.add(check(getSubarray(nums, l[i], r[i])));
        }
        return answer;
    }

    private int[] getSubarray(int[] nums, int l, int r) {
        int[] temp = new int[r - l + 1];
        int t = l;
        for (int i = 0; i < temp.length; i++, t++) {
            temp[i] = nums[t];
        }
        Arrays.sort(temp);
        return temp;
    }

    private boolean check(int[] subarray) {
        int d = subarray[1] - subarray[0];
        for (int i = 1; i < subarray.length - 1; i++) {
            if (d != subarray[i + 1] - subarray[i]) return false;
        }
        return true;
    }
}
