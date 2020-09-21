import util.Inputs;

import java.math.BigInteger;

public class Prob13 {

    static final String PROBLEM_NR = "13";

    public static void main(String[] args) {
        String input = Inputs.getProblemInput(PROBLEM_NR);
        String[] nbrsStr = input.trim().split("\n");
        BigInteger[] nbrs = new BigInteger[nbrsStr.length];
        for (int i = 0; i < nbrsStr.length; i++) {
            nbrs[i] = new BigInteger(nbrsStr[i]);
        }
        BigInteger res = BigInteger.ZERO;
        for (BigInteger bi : nbrs)
            res = res.add(bi);

        String first10Digs = res.toString().substring(0, 10);
        System.out.println(first10Digs);
    }
}
