package heap;

import _util.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    
    //Runtime: 4.0ms (73.64%), Memory: 44.91MB (9.07%)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = new ListNode(-1);
        ListNode pointer = answer;
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
            list = list.next;
        }

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            pointer.next = new ListNode(curr.val);
            pointer = pointer.next;

            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return answer.next;
    }
}
