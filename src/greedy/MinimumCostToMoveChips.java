package greedy;

import java.util.*;

public class MinimumCostToMoveChips {

    //solution1
    //완전탐색
    //Time : O(N*N) , Space: O(k) (N: position 의 길이, k: 중복제거하고 남은 수의 길이 (k <= N)
    //Runtime: 13 ms, faster than 5.09% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
    //Memory Usage: 39.9 MB, less than 89.02% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
    public int solution1(int[] position) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int pos : position) {
            map.put(pos, map.getOrDefault(pos, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());

        for (int i = 0; i < keyList.size(); i++) {
            int temp = 0;
            for (int j = 0; j < keyList.size(); j++) {
                if (i != j) {
                    temp += getCost(keyList.get(i), keyList.get(j)) * map.get(keyList.get(j));
                }
            }
            min = Math.min(temp, min);
        }

        return min;
    }

    private int getCost(int p1, int p2) {
        return Math.abs(p1 - p2) % 2 == 0 ? 0 : 1;
    }

    //solution2
    //짝수는 0으로, 홀수는 1로 밀면 코스트가 0이고
    //그 중 적은 코인을 가진 곳 (Math.min()) 이 옮겨지면 최소 cost.
    //https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/discuss/398178/Detailed-Explanation-O(n)-or-O(1)-Everything-is-in-0-or-1
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
    //Memory Usage: 39.7 MB, less than 93.87% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
    public int solution2(int[] position) {
        int odd = 0, even = 0;

        for (int pos : position) {
            if (pos % 2 == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }
}
