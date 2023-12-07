//2023-12-07
//https://leetcode.com/problems/largest-odd-number-in-string/description/

package string;

public class LargestOddNumberInString {

    //Runtime: 1ms (100.00%), Memory: 44.80MB (25.46%)
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        for (; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) break;
        }
        return num.substring(0, i + 1);
    }
}
