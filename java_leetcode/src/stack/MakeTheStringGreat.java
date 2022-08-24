// https://leetcode.com/problems/make-the-string-great/submissions/
// 2022-08-23

package stack;

import java.util.Stack;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        System.out.println(solution1("asSAdf"));
        System.out.println(solution2("asSAdf"));
        System.out.println(solution3("asSAdf"));
    }

    //Runtime: 5 ms, faster than 69.66% of Java online submissions for Make The String Great.
    //Memory Usage: 43 MB, less than 54.75% of Java online submissions for Make The String Great.
    public static String solution1(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            if (st.isEmpty()) {
                st.push(s.charAt(i++));
                continue;
            }
            if (checkSame(st.peek(), s.charAt(i))) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
            i++;
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }

    public static String solution2(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }
            if (checkSame(st.peek(), s.charAt(i))) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }

    //https://leetcode.com/problems/make-the-string-great/discuss/2203120/Java-oror-2ms-oror-Faster-than-98.74-oror-No-extra-memory
    //Runtime: 4 ms, faster than 82.98% of Java online submissions for Make The String Great.
    //Memory Usage: 43.4 MB, less than 25.46% of Java online submissions for Make The String Great.
    public static String solution3(String s) {
        int idx;

        do {
            idx = getBadIndex(s);
            if (idx == -1) {
                return s;
            } else {
                s = s.substring(0, idx) + s.substring(idx+2);
            }
        } while (true);
    }

    public static int getBadIndex(String s) {
        for(int i=0; i<s.length()-1; i++){
            if (checkSame(s.charAt(i), s.charAt(i + 1))) {
                return i;
            }
        }
        return -1;
    }

    public static boolean checkSame(char c1, char c2) {
        return Math.abs(c1 - c2) == Math.abs('a' - 'A');
    }

}