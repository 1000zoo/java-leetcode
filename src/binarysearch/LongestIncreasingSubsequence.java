//2023-11-17
//https://leetcode.com/problems/longest-increasing-subsequence/

package binarysearch;

import java.util.*;

public class LongestIncreasingSubsequence {

    // Runtime: 4ms Beats 90.33%
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (list.isEmpty() || getLast(list) < num) {
                list.add(num);
            } else {
                process(list, num);
            }
            System.out.println(list);
        }

        return list.size();
    }

    private void process(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        list.set(right, num);
    }

    private int getLast(List<Integer> list) {
        return list.get(list.size() - 1);
    }
}
