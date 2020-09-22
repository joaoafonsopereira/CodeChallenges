import util.numbers.Combinatorics;

public class Prob15 {

    static final int GRID_WIDTH = 20;


    public static long numPathsInGrid(int gridWidth, int gridHeight) {
        int n = gridWidth + gridHeight; // corresponding line in pascal's triangle
        int kMax = n / 2; // position of the central value in that line (yes, redundant computations)

        // The central value in line n of pascal's triangle holds the number of paths
        // in a grid of gridWidth * gridWidth (noticed the pattern, can't explain formally why it works)
        // TODO: explain formally why it works
        return Combinatorics.combinations(n, kMax);
    }

    public static void main(String[] args) {
        //noinspection SuspiciousNameCombination - it's a fking square
        System.out.println(numPathsInGrid(GRID_WIDTH, GRID_WIDTH));
    }
}
