//https://leetcode.com/problems/middle-of-the-linked-list/
//2022-09-06

package linkedlist;

import java.util.ArrayList;

public class MiddleOfTheLinkedList {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    //Memory Usage: 39.5 MB, less than 98.32% of Java online submissions for Middle of the Linked List
    public static ListNode solution1(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head.next;
        }
        ListNode slower = head;
        ListNode faster = head.next;
        while (faster.next != null) {
            slower = slower.next;
            if (faster.next.next == null) {
                return slower;
            }
            faster = faster.next.next;
        }
        return slower.next;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    //Memory Usage: 41.7 MB, less than 38.81% of Java online submissions for Middle of the Linked List.
    public static ListNode solution2(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head.next;
        }

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        count = count / 2;
        curr = head;
        for (int i = 0; i < count; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
