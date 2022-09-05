//https://leetcode.com/problems/merge-two-sorted-lists/
//2022-08-31

package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {
    //Runtime: 1 ms, faster than 80.07% of Java online submissions for Merge Two Sorted Lists.
    //Memory Usage: 43.8 MB, less than 8.41% of Java online submissions for Merge Two Sorted Lists.
    public static ListNode solution1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode answer = new ListNode();
        ListNode curr = answer;

        while (list1 != null || list2 != null) {
            if (list1.val > list2.val) {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            curr = curr.next;
            if (list1 == null) {
                curr.next = list2;
                break;
            } else if (list2 == null) {
                curr.next = list1;
                break;
            }
        }
        return answer.next;
    }

    public static void main(String[] args) {

    }
}
