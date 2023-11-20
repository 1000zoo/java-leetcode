//2023-11-20
//https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/1102627706/

package binarysearch;

public class PeakIndexInMountainArray {

    //Runtime
    //0 ms Beats 100.00%
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
