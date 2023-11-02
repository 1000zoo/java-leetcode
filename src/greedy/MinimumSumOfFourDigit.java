//https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
//2022-11-17

package greedy;

import java.util.*;

public class MinimumSumOfFourDigit {

    //총 4개의 숫자를 두 개의 숫자로 나누워 그 합이 최소가 되게하려면
    //두 개의 큰 수를 각각의 1의 자리 수에 넣고
    //나머지 두 개의 수를 각각의 10의 자리 수에 넣으면 된다.
    //PriorityQueue 를 이용.
    //num 이 4 자리 수이기 때문에
    //Time , Space 모두 O(1)
    //Runtime: 1 ms, faster than 85.98% of Java online submissions for Minimum Sum of Four Digit Number After Splitting Digits.
    //Memory Usage: 39.1 MB, less than 93.36% of Java online submissions for Minimum Sum of Four Digit Number After Splitting Digits.
    public int minimumSum(int num) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (num > 0) {
            pq.add(num % 10);
            num /= 10;
        }
        int new1 = pq.poll();
        int new2 = pq.poll();
        new1 += 10 * pq.poll();
        new2 += 10 * pq.poll();
        return new1 + new2;
    }
}
