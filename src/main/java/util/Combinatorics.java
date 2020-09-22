package util;


public class Combinatorics {

    static long factorial(int n) {
        long res = 1;
        for (int factor = 2; factor <= n; factor++) {
            res *= factor;
        }
        return res;
    }

    static long combinations(int n, int k) {
        MemoizedFactorial mf = new MemoizedFactorial(n);
        return mf.factorial(n) / mf.factorial(n - k) * mf.factorial(k);
    }

}

