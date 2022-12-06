//https://leetcode.com/problems/baseball-game/
//2022-12-07

package array;

import java.util.*;

public class BaseballGame {

    private final Stack<Integer> record = new Stack<>();
    //Runtime 10 ms 9.87%
    //Memory 45.6 MB 5.44%
    public int calPoints(String[] operations) {
        for (String op : operations) {
            if (isNum(op)) {
                record.push(Integer.parseInt(op));
            } else {
                operator(op);
            }
        }
        return getSum();
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
        }
    }

    private boolean isNum(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException n) {
            return false;
        }
        return true;
    }

    private int getSum() {
        return record.stream().mapToInt(Integer::intValue).sum();
    }

}
