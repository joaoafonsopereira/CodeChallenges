import util.Conversions;
import util.time.Time;

import java.math.BigInteger;

public class Prob20 {

    static void solve() {
        BigInteger bi = BigInteger.ONE;
        for(int i = 2; i <= 100; i++)
            bi = bi.multiply(BigInteger.valueOf(i));

        int[] digits = Conversions.toIntArray(bi.toString());
        int sum = 0;
        for(int d : digits)
            sum += d;

        System.out.println(sum);
    }

    public static void main(String[] args) {
        Time.measureAndPrintExecTime(Prob20::solve);
    }

}
