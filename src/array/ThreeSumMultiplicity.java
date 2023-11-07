//2023-11-07
//https://leetcode.com/problems/3sum-with-multiplicity/

package array;

import java.util.*;

public class ThreeSumMultiplicity {

    public static int threeSumMulti(int[] arr, int target) {
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            int newTarget = target - arr[i];

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < arr.length; j++) {
                int temp = newTarget - arr[j];
                if (map.containsKey(temp)) {
                    count += map.get(temp);
                }
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
        }

        return (int) (count % 1000000007);
    }
}
