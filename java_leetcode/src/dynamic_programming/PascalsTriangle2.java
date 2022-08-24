//2022-01-04
//https://leetcode.com/problems/pascals-triangle-ii/submissions/

package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    //Runtime: 1 ms, faster than 76.98% of Java online submissions for Pascal's Triangle II.
    //Memory Usage: 38.6 MB, less than 8.62% of Java online submissions for Pascal's Triangle II.
    private int getCombination(int n, int r){
        double temp = 1;
        for(int i = 2; i <= n; i++){
            temp *= i;
            if(i <= r) temp /= i;
            if(i <= (n - r)) temp /= i;
        }
        return (int) Math.round(temp);
    }
    public List<Integer> getRow(int rowIndex){
        List<Integer> answer = new ArrayList<>(rowIndex);
        for(int i = 0; i <= rowIndex; i++){
            answer.add(getCombination(rowIndex, i));
        }
        return answer;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle II.
    //Memory Usage: 38.7 MB, less than 8.62% of Java online submissions for Pascal's Triangle II.
    public List<Integer> getRow_(int rowIndex){
        List<Integer> answer = new ArrayList<>(rowIndex);
        int prev = 1;
        answer.add(prev);
        for(int i = 1; i <= rowIndex; i++){
            prev = (int)((long)prev*(rowIndex - i + 1) / i);
            answer.add(prev);
        }
        return answer;
    }
}