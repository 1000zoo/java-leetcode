//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
//2022-09-06

package linkedlist;

import java.util.ArrayList;

public class ConvertBinaryNumberInLinkedListToInteger {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    //Memory Usage: 41.6 MB, less than 48.94% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    public static int solution1(ListNode head) {
        int sum = 0;
        while(head != null){
            sum = (sum << 1) | head.val;
            head = head.next;
        }
        return sum;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    //Memory Usage: 41.6 MB, less than 57.12% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    public static int solution2(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }
}
