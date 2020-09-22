package util;

import exceptions.OutOfRangeException;

public class MemoizedFactorial {

    private final int capacity;
    private int lastComputedFactorial;
    private long[] factorials;

    public MemoizedFactorial(int maxFactorial) {
        if (maxFactorial > 20)
            throw new OutOfRangeException("maxFactorial", 0, 20);
        this.capacity = maxFactorial + 1;
        this.factorials = new long[this.capacity];
        this.factorials[0] = 1; // definition
        this.lastComputedFactorial = 0;
    }

    public long factorial(int n) {
        if (n >= capacity)
            throw new OutOfRangeException("n", 0, capacity - 1);

        if (n <= lastComputedFactorial)
            return factorials[n];

        long res = factorials[lastComputedFactorial];
        for (int factor = lastComputedFactorial + 1; factor <= n; factor++) {
            res *= factor;
            factorials[factor] = res;
        }
        lastComputedFactorial = n;
        return res;
    }


}
