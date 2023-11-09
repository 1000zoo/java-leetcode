//2023-11-09
//https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/description/

package array;

public class NumberOfSubarraysWithLCMEqualToK {

    public int subarrayLCM(int[] nums, int k) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            int lcm = nums[i];
            if (k % lcm != 0) {
                continue;
            }
            for (int j = i; j < nums.length; j++) {
                lcm = lcm(lcm, nums[j]);
                if (lcm > k) {
                    break;
                }
                answer += lcm == k ? 1 : 0;
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
