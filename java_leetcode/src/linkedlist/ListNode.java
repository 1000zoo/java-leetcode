package linkedlist;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(List<Integer> list) {
        ListNode curr = this;
        for (Integer i : list) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;

        while (curr != null) {
            sb.append(curr.val);
            sb.append(",");
            curr = curr.next;
        }
        return sb.toString();
    }
}
