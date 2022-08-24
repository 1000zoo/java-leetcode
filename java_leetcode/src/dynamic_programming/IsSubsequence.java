//https://leetcode.com/problems/is-subsequence/submissions/
//2022-01-04

package dynamic_programming;

public class IsSubsequence {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Subsequence.
    //Memory Usage: 37.4 MB, less than 38.01% of Java online submissions for Is Subsequence.
    public boolean solution1(String s, String t){
        int nextIndex = 0;
        for(char c : s.toCharArray()){
            nextIndex = t.indexOf(c, nextIndex);
            if(nextIndex++ == -1) return false;
        }
        return true;
    }
    //Runtime: 2 ms, faster than 25.67% of Java online submissions for Is Subsequence.
    //Memory Usage: 38.3 MB, less than 32.86% of Java online submissions for Is Subsequence.
    public boolean solution2(String s, String t){
        int cnt = 0;
        int tempIndex = -1;
        for(int i = 0; i < s.length(); i++){
            for(int j = tempIndex + 1; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)) {
                    cnt++;
                    tempIndex = j;
                    break;
                }
            }
        }
        return cnt == s.length();
    }
    //Runtime: 2 ms, faster than 25.67% of Java online submissions for Is Subsequence.
    //Memory Usage: 39.1 MB, less than 11.88% of Java online submissions for Is Subsequence.
    public boolean solution3(String s, String t){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
