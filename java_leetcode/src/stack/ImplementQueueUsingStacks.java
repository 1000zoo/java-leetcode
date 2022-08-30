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

    public static class Solution2 {

        public Solution2() {}

        public void push(int x) {
        }
        public int pop() {
            return 1;
        }
        public int peek() {
            return 1;
        }
        public boolean empty() {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution1 queue = new Solution1();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
