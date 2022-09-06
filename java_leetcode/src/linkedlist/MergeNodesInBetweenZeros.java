//https://leetcode.com/problems/merge-nodes-in-between-zeros/
//2022-09-06

package linkedlist;

import java.util.ArrayList;

public class MergeNodesInBetweenZeros {

    //Runtime: 14 ms, faster than 34.38% of Java online submissions for Merge Nodes in Between Zeros.
    //Memory Usage: 298.2 MB, less than 48.43% of Java online submissions for Merge Nodes in Between Zeros.
    public static ListNode solution1(ListNode head) {
        if (head.val != 0 || head.next == null) {
            return null;
        }
        int mergeSum = 0;
        ListNode answer = new ListNode();
        ListNode answerCurr = answer;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val != 0) {
                mergeSum += curr.val;
            } else {
                answerCurr.next = new ListNode(mergeSum);
                answerCurr = answerCurr.next;
                mergeSum = 0;
            }
            curr = curr.next;
        }
        return answer.next;
    }

    //Runtime: 15 ms, faster than 26.03% of Java online submissions for Merge Nodes in Between Zeros.
    //Memory Usage: 303.1 MB, less than 38.07% of Java online submissions for Merge Nodes in Between Zeros.
    public static ListNode solution2(ListNode head) {
        if (head.val != 0 || head.next == null) {
            return null;
        }
        int mergeSum = 0;
        ListNode answer = new ListNode();
        ListNode answerCurr = answer;
        ListNode curr = head.next;
        while (curr != null) {
            mergeSum += curr.val;
            if (curr.next.val == 0) {
                curr = curr.next.next;
                answerCurr.next = new ListNode(mergeSum);
                answerCurr = answerCurr.next;
                mergeSum = 0;
            } else {
                curr = curr.next;
            }
        }
        return answer.next;
    }

    //https://leetcode.com/problems/merge-nodes-in-between-zeros/discuss/2535117/C%2B%2B(100-faster-and-best-approach)-oror-O(N)-Time-complexity-oror-Got-through-once
    //Runtime: 7 ms, faster than 94.19% of Java online submissions for Merge Nodes in Between Zeros.
    //Memory Usage: 80.2 MB, less than 92.10% of Java online submissions for Merge Nodes in Between Zeros.
    public static ListNode solution3(ListNode head) {
        ListNode answer = new ListNode();
        ListNode answerCurr = answer;
        ListNode curr = head.next;
        int mergeSum = 0;

        while (curr != null) {
            mergeSum += curr.val;
            if (curr.val == 0) {
                answerCurr.next = new ListNode(mergeSum);
                answerCurr = answerCurr.next;
                mergeSum = 0;
            }
            curr = curr.next;
        }
        return answer.next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arl = new ArrayList<>();
        arl.add(0);
        arl.add(1);
        arl.add(2);
        arl.add(0);
        arl.add(3);
        arl.add(4);
        arl.add(0);
        ListNode n = new ListNode(arl);
        n = n.next;
        System.out.println(solution2(n));
    }
}
