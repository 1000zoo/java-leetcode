//https://leetcode.com/problems/linked-list-cycle/
//2022-08-31

package linkedlist;

import java.util.HashSet;

public class LinkedListCycle {
    //운이 좋을 때
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
    //Memory Usage: 46.1 MB, less than 39.24% of Java online submissions for Linked List Cycle.
    //운이 안 좋을 때
    //Runtime: 2 ms, faster than 19.79% of Java online submissions for Linked List Cycle.
    //Memory Usage: 46.2 MB, less than 29.63% of Java online submissions for Linked List Cycle.
    public boolean solution1(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
            if (cnt > 10000) {
                return true;
            }
        }
        return false;
    }

    //Runtime: 4 ms, faster than 19.22% of Java online submissions for Linked List Cycle.
    //Memory Usage: 42.8 MB, less than 99.25% of Java online submissions for Linked List Cycle.
    public boolean solution2(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        int sizeBackup = 0;

        while (head != null) {
            hs.add(head);
            head = head.next;
            if (hs.size() == sizeBackup) {
                return true;
            }
            sizeBackup = hs.size();
        }
        return false;
    }

    //Runtime: 1 ms, faster than 45.58% of Java online submissions for Linked List Cycle.
    //Memory Usage: 45.9 MB, less than 45.19% of Java online submissions for Linked List Cycle.
    public boolean solution3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode faster = head;
        ListNode slower = head;

        while (true) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == null || faster.next == null || slower == null) {
                return false;
            }
            if (faster == slower) {
                return true;
            }
        }
    }

}
