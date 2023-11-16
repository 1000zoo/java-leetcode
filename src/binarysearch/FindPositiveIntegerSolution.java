//2023-11-16
//https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

package binarysearch;

import java.util.*;

public class FindPositiveIntegerSolution {
    /**
     *  This is the custom function interface.
     *  You should not implement it, or speculate about its implementation
     *  class CustomFunction {
     *       Returns f(x, y) for any given positive integers x and y.
     *  *     // Note that f(x, y) is increasing with respect to both x and y.
     *  *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *  *     public int f(int x, int y);
     *  * };
     */
    private static class CustomFunction {
        private int f(int x, int y) {
            return x + y;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int x = 1; x <= 1000; x++) {
            int left = 1;
            int right = 1000;

            while (left < right) {
                int y = (left + right) / 2;
                int result = customfunction.f(x, y);

                if (result < z) {
                    left = y + 1;
                } else if (result > z){
                    right = y;
                } else {
                    answer.add(List.of(x, y));
                    break;
                }
            }

        }

        return answer;
    }
}
