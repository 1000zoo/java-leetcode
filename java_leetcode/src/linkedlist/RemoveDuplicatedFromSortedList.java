//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//2022-08-31

package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatedFromSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mk(List<Integer> list) {
        ListNode listNode = new ListNode();
        ListNode curr = listNode;
        for (Integer i : list) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return listNode.next;
    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //Runtime: 1 ms, faster than 79.52% of Java online submissions for Remove Duplicates from Sorted List.
    //Memory Usage: 44.4 MB, less than 29.86% of Java online submissions for Remove Duplicates from Sorted List.
    public static ListNode solution1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode front = head;
        ListNode back = head;

        while (front.next != null) {
            if (back.val != front.next.val) {
                back.next = front.next;
                back = back.next;
            }
            front = front.next;
            if (front.next == null) {
                back.next = null;
            }
        }
        return head;
    }


    //Runtime: 2 ms, faster than 6.69% of Java online submissions for Remove Duplicates from Sorted List.
    //Memory Usage: 44.2 MB, less than 53.30% of Java online submissions for Remove Duplicates from Sorted List.
    public static ListNode solution2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode answer = new ListNode();
        ListNode dummy = answer;
        ListNode curr = head;

        int val = -101;

        while (curr != null) {
            if (val != curr.val) {
                val = curr.val;
                answer.next = new ListNode(val);
                answer = answer.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        ListNode head = mk(list);
        ListNode answer = solution1(head);
        printNode(answer);

    }
}
