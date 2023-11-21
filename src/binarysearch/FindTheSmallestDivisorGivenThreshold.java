//2023-11-21
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

package binarysearch;

public class FindTheSmallestDivisorGivenThreshold {

    //Runtime: 28ms Beats 71.59%
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = getMax(nums);

        while (left < right) {
            int mid = (left + right) / 2;
            long result = getSum(nums, mid);

            if (result <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private long getSum(int[] nums, int divisor) {
        long sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / divisor);
        }
        return sum;
    }

    //Runtime: 7 ms Beats 92.97%
    private long getSumFaster(int[] nums, int divisor) {
        long sum = 0;
        for (int num : nums) {
            sum += (divisor + num - 1) / divisor;
        }
        return sum;
    }
}