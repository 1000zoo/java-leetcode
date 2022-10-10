//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
//2022-08-03

package stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    //Runtime: 96 ms, faster than 46.51% of Java online submissions for Remove All Adjacent Duplicates In String.
    //Memory Usage: 54.7 MB, less than 53.79% of Java online submissions for Remove All Adjacent Duplicates In String.
    public static String solution1(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans.reverse();

        return ans.toString();
    }
}
