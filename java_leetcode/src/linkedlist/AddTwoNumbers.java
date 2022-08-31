//https://leetcode.com/problems/add-two-numbers/
//2022-08-31

package linkedlist;

public class AddTwoNumbers {
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

    //Runtime: 4 ms, faster than 37.39% of Java online submissions for Add Two Numbers.
    //Memory Usage: 47.3 MB, less than 78.94% of Java online submissions for Add Two Numbers.
    public static ListNode solution1(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode curr = answer;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return answer.next;
    }

    //Wrong answer
    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode curr = answer;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;

            if (l1 == null && l2 != null) {
                l2.val += carry;
                curr.next = l2;
                break;
            } else if (l1 != null && l2 == null) {
                l1.val += carry;
                curr.next = l1;
                break;
            } else {
                curr = curr.next;
            }
        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return answer.next;
    }

    // Wrong answer => 노드의 길이는 (1, 100) => int 나 long 으로 감당 안됨
    public static ListNode solution3(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode curr = answer;

        int n1 = 0;
        int n2 = 0;
        int m = 1;

        while (l1 != null) {
            n1 += l1.val * m;
            m *= 10;
            l1 = l1.next;
        }
        m = 1;
        while (l2 != null) {
            n2 += l2.val * m;
            m *= 10;
            l2 = l2.next;
        }

        int sum = n1 + n2;

        while (sum > 0) {
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
        }
        return answer.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4, n1);
        ListNode n3 = new ListNode(2, n2);

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(6, n4);
        ListNode n6 = new ListNode(5, n5);

        ListNode n = solution2(n3, n6);
        ListNode curr = n;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
