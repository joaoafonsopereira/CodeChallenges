import util.Conversions;
import util.Inputs;

public class Prob67 {

    static final String PROBLEM_NR = "67";

    public static void main(String[] args) {
        String input = Inputs.getProblemInput(PROBLEM_NR);
        int[][] triangle = Conversions.parseTriangle(input);
        System.out.println(Prob18.maxPath(triangle));
    }
}
