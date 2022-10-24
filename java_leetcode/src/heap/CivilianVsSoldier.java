//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
//2022-10-22
//The K Weakest Rows in a Matrix

package heap;

import java.util.*;

public class CivilianVsSoldier {

    //solution1
    //==================================================================================================================
    //Runtime: 6 ms, faster than 39.64% of Java online submissions for The K Weakest Rows in a Matrix.
    //Memory Usage: 48.3 MB, less than 77.96% of Java online submissions for The K Weakest Rows in a Matrix.
    public int[] solution1(int[][] mat, int k) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < mat.length; i++) {
            int soldier = countSoldiers(mat[i]);
            List<Integer> temp = map.getOrDefault(soldier, new ArrayList<>());
            temp.add(i);
            map.put(soldier, temp);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.addAll(map.get(key));
        }
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    private int countSoldiers(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) return i;
        }
        return row.length;
    }
    //==================================================================================================================
}
