//https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/submissions/
//2022-10-31

package heap;

import java.util.*;

public class SubsequenceOfLargestSum {

    //solution1
    //map 을 이용
    //Runtime: 22 ms, faster than 31.23% of Java online submissions for Find Subsequence of Length K With the Largest Sum.
    //Memory Usage: 45.2 MB, less than 17.01% of Java online submissions for Find Subsequence of Length K With the Largest Sum.
    public static int[] solution1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }


        List<Integer> keySetList = new ArrayList<>(map.keySet());
        keySetList.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int[] answer = new int[k];
        int[] index = new int[k];
        for (int i = 0; i < k; i++) {
            index[i] = keySetList.get(i);
        }
        Arrays.sort(index);
        for (int i = 0; i < k; i++) {
            answer[i] = nums[index[i]];
        }

        return answer;
    }
}
