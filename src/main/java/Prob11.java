import util.*;

public class Prob11 {

    static final String PROBLEM_NR = "11";

    static final int FACTORS_IN_PROD = 4;
    static final int GRID_WIDTH = 20;


    static boolean hasRightProd(int j) {
        return j <= GRID_WIDTH - FACTORS_IN_PROD;
    }

    static boolean hasDownProd(int i) {
        return i <= GRID_WIDTH - FACTORS_IN_PROD;
    }

    static int maxHorizontalProduct(int[][] grid) {
        int maxProd = 1;
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; hasRightProd(j); j++) {
                int prod = 1;
                for (int k = j; k < j + FACTORS_IN_PROD; k++)
                    prod *= grid[i][k];
                if (prod > maxProd)
                    maxProd = prod;
            }
        }
        return maxProd;
    }

    static int maxVerticalProduct(int[][] grid) {
        int maxProd = 1;
        for (int j = 0; j < GRID_WIDTH; j++) {
            for (int i = 0; hasDownProd(i); i++) {
                int prod = 1;
                for (int k = i; k < i + FACTORS_IN_PROD; k++)
                    prod *= grid[k][j];
                if (prod > maxProd)
                    maxProd = prod;
            }
        }
        return maxProd;
    }

    //   \
    static int maxDiag1Product(int[][] grid) {
        int maxProd = 1;
        for (int i = 0; hasDownProd(i); i++) {
            for (int j = 0; hasRightProd(j); j++) {
                int prod = 1;
                for (int k = 0; k < FACTORS_IN_PROD; k++)
                    prod *= grid[i + k][j + k];
                if (prod > maxProd)
                    maxProd = prod;
            }
        }
        return maxProd;
    }

    //   /
    static int maxDiag2Product(int[][] grid) {
        int maxProd = 1;
        for (int i = 0; hasDownProd(i); i++) {
            for (int j = FACTORS_IN_PROD - 1; j < GRID_WIDTH; j++) {
                int prod = 1;
                for (int k = 0; k < FACTORS_IN_PROD; k++)
                    prod *= grid[i + k][j - k];
                if (prod > maxProd)
                    maxProd = prod;
            }
        }

        return maxProd;
    }


    public static void main(String[] args) {
        String GRID = Inputs.getProblemInput(PROBLEM_NR);
        final String[] gridStr = GRID.replace("\n", " ").split(" ");
        final int[][] grid = Util.toIntMatrix(gridStr, GRID_WIDTH);

        int maxHProd = maxHorizontalProduct(grid);
        int maxVProd = maxVerticalProduct(grid);
        int maxD1Prod = maxDiag1Product(grid);
        int maxD2Prod = maxDiag2Product(grid);

        int max = Util.max(maxHProd, maxVProd, maxD1Prod, maxD2Prod);
        System.out.println(max);
        System.out.println("----");
        System.out.println("H:  " + maxHProd);
        System.out.println("V:  " + maxVProd);
        System.out.println("D1: " + maxD1Prod);
        System.out.println("D2: " + maxD2Prod);
    }


}
