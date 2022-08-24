//https://leetcode.com/problems/next-greater-element-i/submissions/
//2022-08-02

package stack;

import java.util.Stack;

public class NextGreaterElement1 {

    //Runtime: 463 ms, faster than 5.11% of Java online submissions for Next Greater Element I.
    //Memory Usage: 117.6 MB, less than 5.63% of Java online submissions for Next Greater Element I.
    public static int[] solution1(int[] num1, int[] num2) {
        int[] ans = new int[num1.length];
        for (int i = 0; i < num1.length; i++) {
            Stack<Integer> numStack = arrToStack(num2);
            int k = -1;
            while (!numStack.isEmpty()) {
                int curr = numStack.pop();
                if (num1[i] == curr) {
                    break;
                } else if (num1[i] < curr) {
                    k = curr;
                }
            }
            ans[i] = k;
        }
        return ans;
    }

    //Runtime: 4 ms, faster than 82.10% of Java online submissions for Next Greater Element I.
    //Memory Usage: 43.8 MB, less than 72.29% of Java online submissions for Next Greater Element I.
    public static int[] solution2(int[] num1, int[] num2) {
        int[] ans = new int[num1.length];
        for (int i = 0; i < num1.length; i++) {
            int k = -1;
            int j = 0;
            while(num1[i] != num2[j]) j++;
            for (; j < num2.length; j++) {
                if (num1[i] < num2[j]) {
                    k = num2[j];
                    break;
                }
            }
            ans[i] = k;
        }
        return ans;
    }

    public static Stack<Integer> arrToStack(int[] num) {
        Stack<Integer> ans = new Stack<>();
        for (int i : num) {
            ans.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {4,2};
        int[] num2 = {4,1,2,3,5};
        int[] ans = solution2(num1, num2);
        for (int n : ans) {
            System.out.println(n);
        }
    }

}
