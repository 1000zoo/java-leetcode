//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/submissions/856256193/
//2022-12-08

package array;

import java.util.*;

public class SortIntegersByTheNumberOf1Bits {

    //Complexity
    //Time: O(NlogN)
    //Space: O(N) where N is length of arr
    //Runtime 22 ms 33.81%
    //Memory 43 MB 80.33%
    public int[] solution1(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> keyList = new ArrayList<>();

        for (int num : arr) {
            countMap.put(num, count1Bits(num));
            keyList.add(num);
        }

        keyList.sort((n1, n2) -> countMap.get(n1).equals(countMap.get(n2)) ?
             Integer.compare(n1, n2) : (countMap.get(n1).compareTo(countMap.get(n2))));



        return keyList.stream().mapToInt(i -> i).toArray();
    }

    private int count1Bits(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) count++;
            num /= 2;
        }
        return count;
    }
}
