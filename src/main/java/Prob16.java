import util.Conversions;

import java.math.BigInteger;

public class Prob16 {

    public static void main(String[] args) {
        BigInteger bi = BigInteger.valueOf(2);
        String power = bi.pow(1000).toString();
        int[] digits = Conversions.toIntArray(power);
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        System.out.println(sum);
    }

}
