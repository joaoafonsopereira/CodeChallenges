package util.numbers;

import java.math.BigInteger;

public class BigMemoizedFactorial implements MemoizedFactorial<BigInteger> {

    private int lastComputedFactorial;
    private final BigInteger[] factorials;

    public BigMemoizedFactorial(int maxFactorial) {
        int capacity = maxFactorial + 1;
        this.factorials = new BigInteger[capacity];
        this.factorials[0] = BigInteger.ONE; // definition
        this.lastComputedFactorial = 0;
    }


    @Override
    public BigInteger factorial(int n) {

        if (n <= lastComputedFactorial)
            return factorials[n];

        BigInteger res = factorials[lastComputedFactorial];
        for (int factor = lastComputedFactorial + 1; factor <= n; factor++) {
            res = res.multiply(BigInteger.valueOf(factor));
            factorials[factor] = res;
        }
        lastComputedFactorial = n;
        return res;
    }
}
