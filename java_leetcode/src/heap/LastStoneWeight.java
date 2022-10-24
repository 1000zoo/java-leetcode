package heap;

import java.util.*;

public class LastStoneWeight {
    //solution1
    //Priority Queue 사용
    //Runtime: 3 ms, faster than 60.70% of Java online submissions for Last Stone Weight.
    //Memory Usage: 41.6 MB, less than 48.86% of Java online submissions for Last Stone Weight.
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            q.add(i);
        }
        while (q.size() > 1) {
            q.add(Math.abs(q.poll() - q.poll()));
        }
        return q.poll();
    }
}
