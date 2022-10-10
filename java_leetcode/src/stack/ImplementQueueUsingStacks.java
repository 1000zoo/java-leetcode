//https://leetcode.com/problems/implement-queue-using-stacks/
//2022-08-30

package stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    //Runtime: 1 ms, faster than 70.40% of Java online submissions for Implement Queue using Stacks.
    //Memory Usage: 42 MB, less than 30.90% of Java online submissions for Implement Queue using Stacks.
    public static class Solution1 {
        private final Stack<Integer> st1;
        private final Stack<Integer> st2;

        public Solution1() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }

        public void push(int x) {
            if (st2.isEmpty()) {
                st2.push(x);
            } else {
                while (!st2.isEmpty()) {
                    st1.push(st2.pop());
                }
                st2.push(x);
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
        }

        // 문제조건 : 모든 pop 과 peek 은 유효함 => NullPointerException 이 존재하는 경우는 무시함
        public int pop() {
            return st2.pop();
        }

        public int peek() {
            return st2.peek();
        }

        public boolean empty() {
            return st2.isEmpty();
        }
    }
}
