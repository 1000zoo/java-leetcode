//2022-01-04
//https://leetcode.com/problems/pascals-triangle/submissions/

package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    private int getCombination(int n, int r){
        double temp = 1;
        for(int i = 2; i <= n; i++){
            temp *= i;
            if(i <= r) temp /= i;
            if(i <= (n - r)) temp /= i;
        }
        return (int) Math.round(temp);
    }
    //Runtime: 1 ms, faster than 22.65% of Java online submissions for Pascal's Triangle.
    //Memory Usage: 38.1 MB, less than 23.49% of Java online submissions for Pascal's Triangle.
    public List<List<Integer>> generate_(int numRows){
        List<List<Integer>> total = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                row.add(getCombination(i, j));
            }
            total.add(row);
        }
        return total;
    }
    //Runtime: 1 ms, faster than 22.65% of Java online submissions for Pascal's Triangle.
    //Memory Usage: 38.3 MB, less than 22.23% of Java online submissions for Pascal's Triangle.
    public List<List<Integer>> generate__(int numRows){
        List<List<Integer>> total = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) row.add(1);
                else row.add(total.get(i - 1).get(j - 1) + total.get(i - 1).get(j));
            }
            total.add(row);
        }
        return total;
    }
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
    //Memory Usage: 36.4 MB, less than 99.32% of Java online submissions for Pascal's Triangle.
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) row.add(1);
                else row.add(total.get(i - 1).get(j - 1) + total.get(i - 1).get(j));
            }
            total.add(row);
            row = new ArrayList<>();
        }
        return total;
    }
}