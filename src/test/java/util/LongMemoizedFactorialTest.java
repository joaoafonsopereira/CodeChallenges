package util;

import org.junit.jupiter.api.Test;
import util.numbers.Combinatorics;
import util.numbers.LongMemoizedFactorial;
import util.numbers.MemoizedFactorial;

import java.util.function.Consumer;

class LongMemoizedFactorialTest {

    @Test
    void testFactorial() {
        int maxFact = 20;
        MemoizedFactorial<Long> mf = new LongMemoizedFactorial(maxFact);
        for(int i = 0; i <= maxFact; i++)
            assert mf.factorial(i) == Combinatorics.factorial(i);
    }


    @Test
    void compareTimes() {
        measureTime(this::fact0);
        measureTime(this::fact1);
        measureTime(this::fact2);
    }



    @SuppressWarnings("ResultOfMethodCallIgnored")
    void fact0(int limit) {
        for(int i = 0; i <= limit; i++) {
            Combinatorics.factorial(i);
        }
    }

    void fact1(int limit) {
        MemoizedFactorial<Long> mf1 = new LongMemoizedFactorial(limit);
        for(int i = 0; i <= limit; i++) {
            mf1.factorial(i);
        }
    }

    // Using MemoizedFactorial but iterating backwards
    void fact2(int limit) {
        MemoizedFactorial<Long> mf2 = new LongMemoizedFactorial(limit);
        for(int i = limit; i >= 0; i--) {

            mf2.factorial(i);
        }
    }


    void measureTime(Consumer<Integer> method) {
        double start = System.nanoTime();
        method.accept(20);
//        double time = (System.nanoTime() - start) * 1.0 / 1000000000;
        double time = (System.nanoTime() - start) * 1.0;
        System.out.println("Time of " + method.toString() + " = " + time);
    }

}