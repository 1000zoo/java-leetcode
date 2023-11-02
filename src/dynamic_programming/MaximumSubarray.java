//https://leetcode.com/problems/maximum-subarray/
//2021-12-22

package dynamic_programming;

public class MaximumSubarray {
    //time limit exceeded
    public int maxSubArray_time_limit1(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] iSum = new int[nums.length + 1];
        int ans = 0;
        int totalSum = 0;
        int min = 0;
        iSum[0] = 0;

        for(int i = 1; i <= nums.length; i++){
            iSum[i] = iSum[i - 1] + nums[i - 1];
        }
        totalSum = iSum[nums.length];

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - i; j++){
                min = Math.min(iSum[i] + (totalSum - iSum[nums.length - j]), min);
            }
        }
        ans = totalSum - min;

        return ans;
    }
    //Time Limit Exceeded
    public int maxSubArray_time_limit2(int[] nums){
        int sum = 0;
        int maxSum = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(maxSum < sum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
    //Memory Usage: 47.6 MB, less than 98.93% of Java online submissions for Maximum Subarray.
    public int maxSubArray(int[] nums){
        int max = nums[0];
        int s[] = new int[nums.length];
        s[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            s[i] = Math.max(s[i - 1] + nums[i], nums[i]);
            if(s[i] > max){
                max = s[i];
            }
        }

        return max;
    }
}