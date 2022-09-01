//https://leetcode.com/problems/remove-linked-list-elements/
//2022-09-02

package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveLinkedListElements {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

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

    //Runtime: 1 ms, faster than 99.05% of Java online submissions for Remove Linked List Elements.
    //Memory Usage: 49.2 MB, less than 43.42% of Java online submissions for Remove Linked List Elements.
    public static ListNode solution1(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode front = head;
        ListNode tail = new ListNode(-1, front);
        ListNode dummy = tail;

        while (front != null) {
            if (front.val != val) {
                tail.next = front;
                front = front.next;
                tail = tail.next;
            } else {
                front = front.next;
                if (front == null) {
                    tail.next = null;
                }
            }
        }
        return dummy.next;
    }
    //     f
    //   t
    // 1 2 3 4 5

    //Runtime: 1 ms, faster than 99.05% of Java online submissions for Remove Linked List Elements.
    //Memory Usage: 49 MB, less than 51.68% of Java online submissions for Remove Linked List Elements.
    public static ListNode solution2(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(2);
        ListNode ln = toListNode(arr);
        print(ln);
        System.out.println();
        print(solution1(ln, 2));
    }
}
