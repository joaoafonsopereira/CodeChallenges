import util.Inputs;
import util.Strings;
import util.time.Time;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob22 {

    static final String PROBLEM_NR = "22";

    // Just to hide this ugly try-catch
    static String[] getNamesFromInput() {
        String[] names = new String[0];
        try {
            String inputPath = Inputs.problemInputPath(PROBLEM_NR);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(inputPath)));
            names = br.readLine().split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    static void solve() {
        String[] names = getNamesFromInput();
        int[] alphabeticValues = Arrays.stream(names)
                .map(Strings::removeQuotMarks)
                .sorted()
                .mapToInt(Strings::alphabeticalValue)
                .toArray();

        // need the index... would be much nicer to have a Stream.zipWithIndex method
        long sum = 0;
        for (int i = 0; i < alphabeticValues.length; i++) {
            sum += alphabeticValues[i] * (i+1);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Time.measureAndPrintExecTime(Prob22::solve);
    }
}
