package heap;

import java.util.*;

public class ReduceArraySizeOfTheHalf {

    //Runtime: 46 ms, faster than 88.04% of Java online submissions for Reduce Array Size to The Half.
    //Memory Usage: 51.6 MB, less than 92.65% of Java online submissions for Reduce Array Size to The Half.
    public int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>(); //Integer, num of Integer
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int count = 0;
        int sum = 0;

        for (int key : keyList) {
            int val = map.get(key);
            count++;
            if (val + sum >= arr.length / 2) {
                break;
            }
            sum += val;
        }

        return count;
    }
}
