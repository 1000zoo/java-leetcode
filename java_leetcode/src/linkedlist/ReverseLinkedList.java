//https://leetcode.com/problems/reverse-linked-list/
//2022-09-02

package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //------------------------------------------------------------------------
    //util
    public static ListNode toListNode(List<Integer> list) {
        ListNode listNode = new ListNode();
        ListNode curr = listNode;

        for (Integer i : list) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return listNode.next;
    }

    public static void print(ListNode listNode) {
        ListNode dummy = listNode;

        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }
    }
    //------------------------------------------------------------------------

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


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        ListNode n = toListNode(a);
        print(n);
        System.out.println();
        print(solution2(n));
    }

}
