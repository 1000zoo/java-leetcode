//https://leetcode.com/problems/palindrome-linked-list/
//2022-09-02

package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {
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

    //------------------------------------------------------------------------
    //Runtime: 126 ms, faster than 5.20% of Java online submissions for Palindrome Linked List.
    //Memory Usage: 120.4 MB, less than 5.03% of Java online submissions for Palindrome Linked List.
    public static boolean solution1(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }
        ListNode curr = head;
        ListNode reverse = reverse(head);
        while (curr != null) {
            if (curr.val != reverse.val) {
                return false;
            }
            curr = curr.next;
            reverse = reverse.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        Stack<Integer> st = new Stack<>();
        ListNode answer = new ListNode();
        ListNode curr = head;
        ListNode dummy = answer;
        while (curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }
        while (!st.isEmpty()) {
            answer.next = new ListNode(st.pop());
            answer = answer.next;
        }
        return dummy.next;
    }
    //------------------------------------------------------------------------

    //Runtime: 40 ms, faster than 11.31% of Java online submissions for Palindrome Linked List.
    //Memory Usage: 99.2 MB, less than 42.07% of Java online submissions for Palindrome Linked List.
    public static boolean solution2(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }
        StringBuilder sb1 = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb1.append(curr.val);
            curr = curr.next;
        }
        String origin = sb1.toString();
        sb1.reverse();
        String nw = sb1.toString();
        return origin.equals(nw);
    }

    //Runtime: 40 ms, faster than 11.31% of Java online submissions for Palindrome Linked List.
    //Memory Usage: 111 MB, less than 13.63% of Java online submissions for Palindrome Linked List.
    public static boolean solution3(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        int size = st.size() / 2;
        for (int i = 0; i < size; i++) {
            if (curr.val != st.pop()) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        ListNode ln = toListNode(arr);
        solution3(ln);
    }
}
