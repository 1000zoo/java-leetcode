//2023-11-18
//https://leetcode.com/problems/most-beautiful-item-for-each-query/

package binarysearch;

import java.util.*;

public class MostBeautifulItemForEachQuery {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(items, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);

        int[] price = new int[items.length];
        int[] beauty = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            price[i] = items[i][0];
            beauty[i] = items[i][1];
        }

        for (int i = 1; i < beauty.length; i++) {
            beauty[i] = Math.max(beauty[i], beauty[i - 1]);
        }

        for (int i = 0; i < answer.length; i++) {
            if (queries[i] < price[0]) {
                answer[i] = 0;
                continue;
            }
            answer[i] = beauty[findIndex(price, queries[i])];
        }

        return answer;
    }

    private int findIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right + 1) >> 1;

            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
