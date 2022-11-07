//https://leetcode.com/problems/smallest-number-in-infinite-set/submissions/
//2022-11-07

package heap;

import java.util.*;

//set 을 이용한 풀이
//이미 pop 된 숫자를 set 에 집어넣고, popSet 에 없는 숫자 중 가장 최소값만을 기억함
//다시 추가할 시 popSet 에서 제거
//Runtime: 27 ms, faster than 54.84% of Java online submissions for Smallest Number in Infinite Set.
//Memory Usage: 55.7 MB, less than 23.32% of Java online submissions for Smallest Number in Infinite Set.
class SmallestInfiniteSet {
    public Set<Integer> popSet;
    public int curr;

    public SmallestInfiniteSet() {
        popSet = new HashSet<>();
        curr = 1;
    }

    public int popSmallest() {
        int ans = curr;
        popSet.add(curr);
        while (popSet.contains(curr)) {
            curr++;
        }
        return ans;
    }

    public void addBack(int num) {
        popSet.remove(num);
        curr = Math.min(num, curr);
    }
}
