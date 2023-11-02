//https://leetcode.com/problems/maximum-69-number/
//2022-11-21

package greedy;

public class Maximum69Num {

    //Runtime: 1 ms, faster than 87.35% of Java online submissions for Maximum 69 Number.
    //Memory Usage: 41.1 MB, less than 38.00% of Java online submissions for Maximum 69 Number.
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        StringBuilder answer = new StringBuilder();
        boolean noMore = false;
        for (char c : s.toCharArray()) {
            if (c == '6' && !noMore) {
                answer.append(9);
                noMore = true;
            }
            else {
                answer.append(c);
            }
        }
        return Integer.parseInt(answer.toString());
    }
}
