//https://leetcode.com/problems/unique-number-of-occurrences/submissions/856240614/
//2022-12-08

package array;

import java.util.*;

public class UniqueNumberOfOccurrences {

    //Runtime 5 ms 44.59%
    //Memory 42 MB 57.59%
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            occurrence.put(num, occurrence.getOrDefault(num, 0) + 1);
        }

        for (int key : occurrence.keySet()) {
            if (set.contains(occurrence.get(key))) return false;
            set.add(occurrence.get(key));
        }
        return true;
    }
}
