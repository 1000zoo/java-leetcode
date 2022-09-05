//https://leetcode.com/problems/reverse-linked-list/
//2022-09-02

package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {

    //Runtime: 3 ms, faster than 11.91% of Java online submissions for Reverse Linked List.
    //Memory Usage: 43.2 MB, less than 34.51% of Java online submissions for Reverse Linked List.
    public static ListNode solution1(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        Stack<Integer> st = new Stack<>();
        ListNode answer = new ListNode();
        ListNode dummy = answer;
        while (head != null) {
            st.push(head.val);
            head = head.next;
        }
        while (!st.isEmpty()) {
            answer.next = new ListNode(st.pop());
            answer = answer.next;
        }
        return dummy.next;
    }

    //-----------------------------------------------------------------------------
    //Runtime: 21 ms, faster than 11.91% of Java online submissions for Reverse Linked List.
    //Memory Usage: 42.9 MB, less than 59.43% of Java online submissions for Reverse Linked List.
    public static ListNode solution2(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            return recursive(head, head.next);
        }
    }

    public static ListNode recursive(ListNode backup, ListNode curr) {
        if (curr.next == null) {
            curr.next = backup;
            backup.next = null;
            return curr;
        } else {
            ListNode head = recursive(curr, curr.next);
            ListNode temp = head;
            while (temp != curr) {
                temp = temp.next;
            }
            temp.next = backup;
            backup.next = null;
            return head;
        }
    }
    //-----------------------------------------------------------------------------
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    //Memory Usage: 43.6 MB, less than 8.30% of Java online submissions for Reverse Linked List.
    public static ListNode solution3(ListNode head) {
        ListNode answer = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = answer;
            answer = curr;
            curr = next;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
