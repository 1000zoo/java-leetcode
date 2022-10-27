//https://leetcode.com/problems/relative-ranks/
//2022-10-28

package heap;

import java.util.*;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        int rank = 1;
        for(int index : map.keySet()) {
            String temp = "" + (rank);
            if (temp.equals("1")) {
                temp = "Gold Medal";
            } else if (temp.equals("2")) {
                temp = "Silver Medal";
            } else if (temp.equals("3")) {
                temp = "Bronze Medal";
            }
            answer[map.get(index)] = temp;
            rank++;
        }
        return answer;
    }
}
