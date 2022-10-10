//https://leetcode.com/problems/delete-node-in-a-linked-list/
//2022-09-04

package linkedlist;

import java.util.List;

public class DeleteNodeInALinkedList {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
    //Memory Usage: 43.9 MB, less than 48.01% of Java online submissions for Delete Node in a Linked List.
    public void solution1(ListNode node) {
        while (true) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }

    //Leetcode solution
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
    //Memory Usage: 41.9 MB, less than 91.76% of Java online submissions for Delete Node in a Linked List.
    public void solution2(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
