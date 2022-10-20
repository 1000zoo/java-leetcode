//https://leetcode.com/problems/generate-parentheses/
//2022-10-20

package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    //refer : https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
    //Runtime: 3 ms, faster than 53.49% of Java online submissions for Generate Parentheses.
    //Memory Usage: 43.4 MB, less than 67.10% of Java online submissions for Generate Parentheses.

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack(answer, "", 0, 0, n);
        return answer;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}
