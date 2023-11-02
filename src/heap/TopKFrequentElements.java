//https://leetcode.com/problems/top-k-frequent-elements/
//2022-11-14

package heap;

import java.util.*;

public class TopKFrequentElements {

    //Runtime: 35 ms, faster than 36.40% of Java online submissions for Top K Frequent Elements.
    //Memory Usage: 51 MB, less than 24.94% of Java online submissions for Top K Frequent Elements.
    public int[] solution1(int[] nums, int k) {

        int[] answer = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((i1, i2) -> (map.get(i2).compareTo(map.get(i1))));

        for (int i = 0; i < k; i++) {
            answer[i] = keyList.get(i);
        }

        return answer;
    }
}
