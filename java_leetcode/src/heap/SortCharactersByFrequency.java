//https://leetcode.com/problems/sort-characters-by-frequency/
//2022-11-08

package heap;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        StringBuilder sb = new StringBuilder();
        for (char c : keyList) {
            sb.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
        }
        return sb.toString();
    }
}
