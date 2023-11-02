//https://leetcode.com/problems/implement-stack-using-queues/submissions/
//2022-08-30

package stack;

import java.util.Queue;
import java.util.LinkedList;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
//Memory Usage: 42 MB, less than 36.77% of Java online submissions for Implement Stack using Queues.
public class ImplementStackUsingQueues {
    public static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack(){
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            if (q2.isEmpty()) {
                q2.add(x);
            } else {
                while (!q2.isEmpty()) {
                    q1.add(q2.poll());
                }
                q2.add(x);
                while (!q1.isEmpty()) {
                    q2.add(q1.poll());
                }
            }
        }
        // 문제조건 : 모든 pop 과 top 은 유효함 => NullPointerException 이 존재하는 경우는 무시함
        public int pop() {
            return q2.poll();
        }
        public int top() {
            return q2.peek();
        }
        public boolean empty() {
            return q2.isEmpty();
        }
    }
}
