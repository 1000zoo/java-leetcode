//https://leetcode.com/problems/split-a-string-in-balanced-strings/
//2022-11-21

package greedy;

public class SplitStingInBalancedStrings {

    //Runtime: 1 ms, faster than 81.57% of Java online submissions for Split a String in Balanced Strings.
    //Memory Usage: 41.6 MB, less than 75.00% of Java online submissions for Split a String in Balanced Strings.
    public int solution(String s) {
        int answer = 0, count = 0;
        for (char c : s.toCharArray()) {
            count += c == 'L' ? 1 : -1;
            if (count == 0) answer++;
        }
        return answer;
    }
}
