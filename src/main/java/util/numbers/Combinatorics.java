package util.numbers;


import java.math.BigInteger;

public class Combinatorics {

    public static long factorial(int n) {
        long res = 1;
        for (int factor = 2; factor <= n; factor++) {
            res *= factor;
        }
        return res;
    }


    public static long combinations(int n, int k) {
        if (n <= 20) {
            MemoizedFactorial<Long> mf = new LongMemoizedFactorial(n);
            return mf.factorial(n) / mf.factorial(n - k) * mf.factorial(k);
        } else {
            MemoizedFactorial<BigInteger> mf = new BigMemoizedFactorial(n);
            BigInteger res = mf.factorial(n).divide(mf.factorial(n - k).multiply(mf.factorial(k)));
            return res.longValue();
        }
    }

}

