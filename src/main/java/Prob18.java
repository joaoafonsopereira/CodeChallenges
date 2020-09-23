
import util.Conversions;
import util.Inputs;

public class Prob18 {

    static final String PROBLEM_NR = "18";


    public static int maxPath(int[][] triangle) {
        final int nLines = triangle.length;

        int[][] maxIntermediatePaths = triangle.clone();
        for (int i = nLines - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++)
                maxIntermediatePaths[i][j] += Math.max(maxIntermediatePaths[i + 1][j],
                                                       maxIntermediatePaths[i + 1][j + 1]);
        }
        return maxIntermediatePaths[0][0];
    }


    public static void main(String[] args) {
        String input = Inputs.getProblemInput(PROBLEM_NR, 1);
        int[][] triangle = Conversions.parseTriangle(input);
        System.out.println(maxPath(triangle));

    }
}
