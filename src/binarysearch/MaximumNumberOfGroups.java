//2023-11-21
//https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/

package binarysearch;

public class MaximumNumberOfGroups {

    //Runtime 0 ms Beats 100.00%
    public int maximumGroups(int[] grades) {
        int left = 1;
        int right = grades.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (validate(mid, grades.length)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    private boolean validate(int num, int totalLength) {
        return ((long) num * (num + 1)) / 2 > totalLength;
    }
}

