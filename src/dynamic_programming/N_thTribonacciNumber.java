//https://leetcode.com/problems/n-th-tribonacci-number/
//2022-01-04

package dynamic_programming;

public class N_thTribonacciNumber {
    //time limited
    public int triB(int n) {
        if(n == 0 || n == 1) return n;
        if(n == 2) return 1;
        return triB(n - 1) + triB(n - 2) + triB(n - 3);
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
    //Memory Usage: 35.8 MB, less than 56.25% of Java online submissions for N-th Tribonacci Number.
    public int solution1(int n){
        if(n == 0 || n == 1) return n;
        if(n == 2) return 1;
        int tri[] = new int[3];
        int ans = 0;
        tri[0] = 0;
        tri[1] = 1;
        tri[2] = 1;

        for(int i = 3; i <= n; i++){
            ans = tri[0] + tri[1] + tri[2];
            tri[i % 3] = ans;
        }

        return 0;
    }

}