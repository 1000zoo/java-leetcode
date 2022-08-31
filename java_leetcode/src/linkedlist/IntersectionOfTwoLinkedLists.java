//https://leetcode.com/problems/intersection-of-two-linked-lists/
//2022-08-31

package linkedlist;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    static public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //Runtime: 9 ms, faster than 25.75% of Java online submissions for Intersection of Two Linked Lists.
    //Memory Usage: 54.8 MB, less than 73.21% of Java online submissions for Intersection of Two Linked Lists.
    //Time : O(A + B)
    //Space : O(A)
    public ListNode solution1(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet<>();
        while (headA != null) {
            hs.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hs.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    //Runtime: 540 ms, faster than 6.25% of Java online submissions for Intersection of Two Linked Lists.
    //Memory Usage: 55.7 MB, less than 23.54% of Java online submissions for Intersection of Two Linked Lists.
    //Time : O(A * B)
    //Space : O(1)
    public ListNode solution2(ListNode headA, ListNode headB) {
        ListNode temp = headB;
        while (headA != null) {
            while (headB != null) {
                if (headA == headB) {
                    return headB;
                }
                headB = headB.next;
            }
            headA = headA.next;
            headB = temp;
        }
        return null;
    }

    //Runtime: 514 ms, faster than 7.44% of Java online submissions for Intersection of Two Linked Lists.
    //Memory Usage: 55.7 MB, less than 29.50% of Java online submissions for Intersection of Two Linked Lists.
    //Time : O(A * B)
    //Space: O(1)
    public ListNode solution3(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (headA != null || headB != null) {
            if (headA == headB) {
                return headB;
            }
            headA = headA.next;
            headB = headB.next;
            if (headA == null && headB != null) {
                headA = tempA;
            } else if (headA != null && headB == null) {
                headB = tempB;
            }
        }
        return null;
    }

    //Runtime: 2 ms, faster than 59.16% of Java online submissions for Intersection of Two Linked Lists.
    //Memory Usage: 56.5 MB, less than 7.22% of Java online submissions for Intersection of Two Linked Lists.
    public ListNode solution4(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        while (a != null || b != null) {
            if (a == null) {
                a = headB;
            } else if (b == null) {
                b = headA;
            } else if (a == b) {
              return a;
            } else{
                    a = a.next;
                    b = b.next;
                }
            }
        return null;
    }
}
