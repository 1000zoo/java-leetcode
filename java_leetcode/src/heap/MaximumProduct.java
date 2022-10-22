//
//2022-10-22

package heap;

import java.util.*;

public class MaximumProduct {

    //solution1
    //정렬을 해서 가장 큰 두 수의 곱을 리턴
    //Time : sort => best : O(NlogN), worst : O(N^2)
    //Space: O(1)
    //Runtime: 2 ms, faster than 79.59% of Java online submissions for Maximum Product of Two Elements in an Array.
    //Memory Usage: 41.8 MB, less than 90.46% of Java online submissions for Maximum Product of Two Elements in an Array.
    public int solution1(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 2] - 1) * (nums[nums.length - 1] - 1);
    }

    //solution2
    //Priority Queue 를 이용해 최대값 정렬
    //Time : O(N * logN)
    //Space: O(N)
    //Runtime: 6 ms, faster than 25.78% of Java online submissions for Maximum Product of Two Elements in an Array.
    //Memory Usage: 44.1 MB, less than 5.99% of Java online submissions for Maximum Product of Two Elements in an Array.
    public int solution2(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            q.add(num - 1);
        }
        return q.poll() * q.poll();
    }


    //solution3
    //최대값 두 개를 찾기
    //Time : O(N)
    //Space: O(1)
    //Runtime: 2 ms, faster than 79.59% of Java online submissions for Maximum Product of Two Elements in an Array.
    //Memory Usage: 43.4 MB, less than 41.10% of Java online submissions for Maximum Product of Two Elements in an Array.
    public int solution3(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int num : nums) {
            if (num > max2) {
                if (num > max1) {
                    int temp = max1;
                    max1 = num;
                    max2 = temp;
                } else {
                    max2 = num;
                }
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
