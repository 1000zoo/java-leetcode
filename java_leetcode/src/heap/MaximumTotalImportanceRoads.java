package heap;

import java.util.*;

public class MaximumTotalImportanceRoads {

    //Time Complexity => O(NLogN) (worst case : O(N^2)) (where N is roads.length)
    //Space Complexity => O(N * 2) = O(N)
    //Runtime: 68 ms, faster than 36.23% of Java online submissions for Maximum Total Importance of Roads.
    //Memory Usage: 66.7 MB, less than 87.68% of Java online submissions for Maximum Total Importance of Roads.
    public long solution1(int n, int[][] roads) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] road : roads) {
            for (int city : road) {
                //worst case => Time Complexity : O(N), usually O(1)
                map.put(city, map.getOrDefault(city, 0) + 1);
            }
        }
        List<Integer> sortedKeyList = new ArrayList<>(map.keySet());
        //Time Complexity : O(NlogN * c) (c = comparator 의 Time complexity = O(1)) (get => O(1))
        sortedKeyList.sort((c1, c2) -> (map.get(c2).compareTo(map.get(c1))));

        for (int city : sortedKeyList) {
            answer += (long) (n--) * map.get(city);
        }

        return answer;
    }

    //Time : O(NLogN)
    //Space: O(N)
    //Runtime: 15 ms, faster than 85.02% of Java online submissions for Maximum Total Importance of Roads.
    //Memory Usage: 125.9 MB, less than 28.26% of Java online submissions for Maximum Total Importance of Roads.
    public long solution2(int n, int[][] roads) {
        long ans = 0, x = 1;
        long[] degree = new long[n];
        for(int[] road : roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree); //O(NLogN)
        for(long i : degree) ans +=  i * (x++) ;
        return ans;
    }
}
