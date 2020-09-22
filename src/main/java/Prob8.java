import util.Inputs;
import util.Conversions;

public class Prob8 {

    static final String PROBLEM_NR = "8";

    static int[] get1000DigitNumber() throws Exception {
        String separatedDigitLines = Inputs.getProblemInput(PROBLEM_NR);
        String digitsStr = separatedDigitLines.replace("\n", "");
        return Conversions.toIntArray(digitsStr);
    }

    static long getProdBetween(int[] digits, int start, int end) {
        long prod = 1;
        for (int i = start; i <= end; i++)
            prod *= digits[i];
        return prod;
    }

    public static void main(String[] args) throws Exception {
        final int[] digits = get1000DigitNumber();

        long prod = getProdBetween(digits, 0, 12);
        long maxProd = prod;
        int prev = 0, next = prev + 13;

        while (next < 1000) {
            prod = prod / digits[prev];
            prod = prod * digits[next];
            while (prod == 0) {
                // (assuming no 0 in first 13 digits)
                // entering this loop means digits[next] == 0. Any product involving this 0
                // will turn out to be 0; hence, skip all the 13 possible products and compute
                // the new product ( digits[next+1] * ... * digits[(next+1)+12] ) from the estaca 0

                if (next >= 1000 - 13)
                    break;

                prod = getProdBetween(digits, next + 1, (next + 1) + 12);
                prev = next;
                next = prev + 13;
            }
            if (prod > maxProd)
                maxProd = prod;
            prev++;
            next++;
        }
        System.out.println(maxProd);

    }
}
