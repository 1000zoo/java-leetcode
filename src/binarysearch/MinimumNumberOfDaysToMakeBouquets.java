//2023-11-21
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

package binarysearch;

public class MinimumNumberOfDaysToMakeBouquets {

    //Runtime: 19 ms Beats 36.89%
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k) {
            return -1;
        }

        int left = 1;
        int right = getMax(bloomDay);

        while (left < right) {
            int mid = (left + right) / 2;

            if (validate(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean validate(int[] bloomDay, int m, int k, int mid) {
        int mCount = 0;
        int kCount = 0;

        for (int day : bloomDay) {
            if (day <= mid) {
                kCount++;
            } else {
                kCount = 0;
            }

            if (kCount == k) {
                kCount = 0;
                mCount++;
            }
        }

        return mCount >= m;
    }

    private int getMax(int[] array) {
        int max = -1;
        for (int a : array) {
            max = Math.max(max, a);
        }
        return max;
    }
}
