//2023-02-01
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/889315435/

package array;

public class FindNumWithEvenNumOfDigit {

    //Runtime 2 ms 46.13%
    //Memory 41.6 MB 94.54%
    public int findNumbers(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            int len = Integer.toString(num).length();
            if (len % 2 == 0) {
                answer++;
            }
        }
        return answer;
    }
}
