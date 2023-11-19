//2023-11-19
//https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

package binarysearch;

public class MaximumValueAtGivenIndex {

    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0;
        int right = maxSum;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, index, n) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;
    }

    private long check(long mid, int index, int n) {
        long left = Math.max(mid - index, 0);
        long result = (mid + left) * (mid - left + 1) / 2;
        long right = Math.max(mid - ((n - 1) - index), 0);
        result += (mid + right) * (mid - right + 1) / 2;
        return result - mid;
    }
}
