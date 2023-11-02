//https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
//2022-10-18

package queue;

import java.util.LinkedList;

public class NumberOfStudentsUnableLunch {
    //solution1
    //queue 사용
    //Runtime: 5 ms, faster than 23.03% of Java online submissions for Number of Students Unable to Eat Lunch.
    //Memory Usage: 41.8 MB, less than 67.67% of Java online submissions for Number of Students Unable to Eat Lunch.
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> q = new LinkedList<>() {{
            for (int student : students) {
                offer(student);
            }
        }};
        LinkedList<Integer> sandQ = new LinkedList<>() {{
            for (int sand : sandwiches) {
                offer(sand);
            }
        }};

        while (!q.isEmpty()) {
            if (q.peek().equals(sandQ.peek())) {
                q.poll();
                sandQ.poll();
            } else {
                q.offer(q.poll());
            }
            if (!q.contains(sandQ.peek())) {
                break;
            }
        }
        return q.size();
    }
}
