//https://leetcode.com/problems/backspace-string-compare/
//2022-08-29

package stack;

import java.util.Stack;

public class BackspaceStringCompare {

    //------------------------------------------------------------------------------------------------
    //Runtime: 4 ms, faster than 39.04% of Java online submissions for Backspace String Compare.
    //Memory Usage: 42.6 MB, less than 19.41% of Java online submissions for Backspace String Compare.
    public static boolean backspaceCompare(String s, String t) {
        return solution1(s).equals(solution1(t));
    }

    public static String solution1(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
    //------------------------------------------------------------------------------------------------
    //Runtime: 3 ms, faster than 55.06% of Java online submissions for Backspace String Compare.
    //Memory Usage: 42 MB, less than 65.89% of Java online submissions for Backspace String Compare.
    public static String solution2(String s) {
        StringBuilder ret = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (ret.length() > 0) {
                    ret.replace(ret.length() - 1, ret.length(), "");
                }
            } else {
                ret.append(s.charAt(i));
            }
        }
        return ret.toString();
    }
    //------------------------------------------------------------------------------------------------
    //https://leetcode.com/problems/backspace-string-compare/discuss/2490889/Java-or-O(1)-easy-to-follow
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
    //Memory Usage: 42.1 MB, less than 58.55% of Java online submissions for Backspace String Compare.
    public static boolean solution3(String s, String t) {
        int sIdx = getIdx(s, s.length() - 1);
        int tIdx = getIdx(t, t.length() - 1);
        while(sIdx >= 0 && tIdx >= 0){
            if(s.charAt(sIdx) != t.charAt(tIdx)) return false;
            sIdx = getIdx(s, sIdx - 1);
            tIdx = getIdx(t, tIdx - 1);
        }
        return (sIdx < 0) && (tIdx < 0);
    }
    public static int getIdx (String str, int idx){
        int count = 0;
        while(idx >= 0){
            if(str.charAt(idx) == '#') count++;
            else if(count > 0) count--;
            else break;
            idx--;
        }
        return idx;
    }
}
