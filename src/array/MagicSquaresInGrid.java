//2023-11-08
//https://leetcode.com/problems/magic-squares-in-grid/description/

package array;

import java.util.*;

public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        if (isInvalidInput(grid)) {
            return 0;
        }

        int answer = 0;

        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (!hasDistinctNumbers(grid, i, j)) {
                    continue;
                }
                answer += isMagicSquare(grid, i, j) ? 1 : 0;
            }
        }

        return answer;
    }

    private boolean hasDistinctNumbers(int[][] grid, int startI, int startJ) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            set.add(i);
        }

        for (int i = startI; i < startI + 3; i++) {
            for (int j = startJ; j < startJ + 3; j++) {
                set.remove(grid[i][j]);
            }
        }

        return set.isEmpty();
    }

    private boolean isMagicSquare(int[][] grid, int startI, int startJ) {
        int rowSum = 0;

        for (int i = startI; i < startI + 3; i++) {
            int sum = 0;
            for (int j = startJ; j < startJ + 3; j++) {
                sum += grid[i][j];
            }
            if (rowSum == 0) {
                rowSum = sum;
            }

            if (rowSum != sum) {
                return false;
            }
        }

        for (int j = startJ; j < startJ + 3; j++) {
            int sum = 0;
            for (int i = startI; i < startI + 3; i++) {
                sum += grid[i][j];
            }

            if (rowSum != sum) {
                return false;
            }
        }

        int leftTopDiagonal = 0;
        int rightTopDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            leftTopDiagonal += grid[startI + i][startJ + i];
            rightTopDiagonal += grid[startI + 2 - i][startJ + i];
        }

        return leftTopDiagonal == rowSum && rightTopDiagonal == rowSum;
    }

    private boolean isInvalidInput(int[][] grid) {
        return grid.length < 3 || grid[0].length < 3;
    }
}
