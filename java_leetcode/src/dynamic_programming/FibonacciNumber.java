//https://leetcode.com/problems/fibonacci-number/
//2021-12-22

package dynamic_programming;

public class FibonacciNumber {
    //Runtime: 8 ms, faster than 20.89% of Java online submissions for Fibonacci Number.
    //Memory Usage: 35.9 MB, less than 37.42% of Java online submissions for Fibonacci Number.
    public int solution1(int n){
        if(n == 0 || n == 1) return n;
        return solution1(n - 2) + solution1(n - 1);
    }
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
    //Memory Usage: 35.2 MB, less than 99.33% of Java online submissions for Fibonacci Number.
    public int solution2(int n){
        if(n == 0 || n == 1) return n;
        int f0 = 0, f1 = 1;
        int f = 0;
        for(int i = 0; i < n - 1; i++){
            f = f0 + f1;
            if(i % 2 == 0) f0 = f;
            else f1 = f;
        }
        return f;
    }
}