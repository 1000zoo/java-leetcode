//2023-11-21
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

package binarysearch;

public class CapacityToShipPackages {

    //Runtime: 9 ms Beats 96.51%
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 0;
        for (int weight : weights) {
            right += weight;
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (validate(mid, days, weights)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private boolean validate(int max, int days, int[] weights) {
        int sum = 0;

        for (int weight : weights) {
            if (max < weight) {
                return false;
            }
            sum += weight;

            if (sum > max) {
                days--;
                sum = weight;
            }
        }

        return days > 0;
    }
}
