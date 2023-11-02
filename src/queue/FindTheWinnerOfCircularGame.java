//https://leetcode.com/problems/find-the-winner-of-the-circular-game/
//2022-10-18

package queue;

import java.util.LinkedList;

class FindTheWinnerOfCircularGame {

    //solution1
    //실제 테이블을 구현한 풀이
    //Runtime: 7 ms, faster than 50.54% of Java online submissions for Find the Winner of the Circular Game.
    //Memory Usage: 41.7 MB, less than 39.71% of Java online submissions for Find the Winner of the Circular Game.
    //==================================================================
    public static class Circular {
        public int num;
        public Circular next;

        Circular(int num) {
            this.num = num;
        }
    }
    public int solution1(int n, int k) {
        Circular curr = new Circular(1);
        Circular first = curr;
        for (int i = 2; i <= n; i++) {
            curr.next = new Circular(i);
            curr = curr.next;
        }
        curr.next = first;
        curr = curr.next;
        for (int i = 0; i < n - 1; i++) {
            curr = iter(curr, k);
        }
        return curr.num;
    }
    private Circular iter(Circular node, int k) {
        for (int i = 0; i < k - 1; i++) {
            node = node.next;
        }
        deleteNode(node);
        return node;
    }
    private void deleteNode(Circular node) {
        Circular temp = node.next;
        node.num = temp.num;
        node.next = temp.next;
    }
    //==================================================================

    //solution2
    //queue 를 이용한 풀이
    //Runtime: 144 ms, faster than 15.80% of Java online submissions for Find the Winner of the Circular Game.
    //Memory Usage: 75.1 MB, less than 21.06% of Java online submissions for Find the Winner of the Circular Game.
    public int solution2(int n, int k) {
        LinkedList<Integer> q = new LinkedList<>(){{
            for (int i = 1; i <= n; i++) {
                add(i);
            }
        }};

        while (q.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                q.add(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }

}