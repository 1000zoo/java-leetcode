//https://leetcode.com/problems/baseball-game/
//2022-12-07

package array;

import java.util.*;

public class BaseballGame {

    private final Stack<Integer> record = new Stack<>();

    //Runtime 8 ms 18.84%
    //Memory 42.5 MB 25.18%

    public int calPoints(String[] operations) {
        for (String op : operations) {
            operator(op);
        }
        return record.stream().mapToInt(Integer::intValue).sum();
    }

    private void operator(String s) {
        switch (s) {
            case "D" -> record.push(record.peek() * 2);
            case "C" -> record.pop();
            case "+" -> {
                int n1 = record.pop();
                int n2 = record.pop();
                record.push(n2);
                record.push(n1);
                record.push(n1 + n2);
            }
            default -> record.push(Integer.parseInt(s));
        }
    }
}
