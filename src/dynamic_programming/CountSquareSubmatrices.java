//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
//2022-10-20

package dynamic_programming;

public class CountSquareSubmatrices {

    //solution1
    //완전탐색?
    // N <= M 일 떄
    //Time : O(N * N * M *(N!) ^ 2) ?
    //Space: O(1)
    //==================================================================================================================
    //Runtime: 512 ms, faster than 5.03% of Java online submissions for Count Square Submatrices with All Ones.
    //Memory Usage: 68.9 MB, less than 63.29% of Java online submissions for Count Square Submatrices with All Ones.
    public int solution1(int[][] matrix) {
        int maxSize = Math.min(matrix.length, matrix[0].length);
        int count = 0;
        for (int side = 1; side <= maxSize; side++) {
            count += count(matrix, side);
        }
        return count;
    }

    private int count(int[][] matrix, int side) {
        int iMax = matrix.length - (side - 1);
        int jMax = matrix[0].length - (side - 1);
        int count = 0;
        for (int i = 0; i < iMax; i++) {
            for (int j = 0; j < jMax; j++) {
                if (isSquare(matrix, i, j, side)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSquare(int[][] matrix, int i, int j, int side) {
        for (int k = i; k < i + side; k++) {
            for (int l = j; l < j + side; l++) {
                if (matrix[k][l] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    //==================================================================================================================

    //solution2
    //dynamic programing
    //refer: https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/441306/JavaC%2B%2BPython-DP-solution
    //Time : O(N * M)
    //Space: O(1)
    public int solution2(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && i != 0 && j != 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                count += matrix[i][j];
            }
        }
        return count;
    }

}
