//https://leetcode.com/problems/k-closest-points-to-origin/
//2022-11-10

package heap;

import java.util.*;

public class KClosestPointsToOrigin {

    //solution1
    //pq 의 정렬 기준을 변경
    //Runtime: 49 ms, faster than 71.03% of Java online submissions for K Closest Points to Origin.
    //Memory Usage: 50.6 MB, less than 92.03% of Java online submissions for K Closest Points to Origin.
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(this::getDistance));
        for (int[] point : points) {
            pq.offer(point);
        }

        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = pq.poll();
        }
        return res;
    }



    private int squareComparator(int[] p1, int[] p2) {
        return Integer.compare(getDistance(p1), getDistance(p2));
    }
    private int getDistance(int[] p) {
        return (int) (Math.pow(p[0], 2) + Math.pow(p[1], 2));
    }

    //문제 잘못 이해
    //원점으로부터 k번 째로 떨어져있는 점들 (같은 거리 포함) 인줄..ㅋ
    public int[][] mis(int[][] points, int k) {
        Map<Integer, ArrayList<int[]>> distance = new HashMap<>();

        for (int[] point : points) {
            int dis = getDistance(point);
            ArrayList<int[]> list = distance.getOrDefault(dis, new ArrayList<>());
            list.add(point);
            distance.put(dis, list);
        }

        List<Integer> keyList = new ArrayList<>(distance.keySet());
        Collections.sort(keyList);

        int index = 0;
        int[][] answer = new int[distance.get(keyList.get(k - 1)).size()][2];

        for (int i = 0; i < k; i++) {
            for (int[] point : distance.get(keyList.get(k - 1))) {
                answer[index++] = point;
            }
        }
        return answer;
    }
}
