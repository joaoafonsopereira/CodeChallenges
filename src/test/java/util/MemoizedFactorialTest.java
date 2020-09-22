package util;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class MemoizedFactorialTest {

    @Test
    void testFactorial() {
        int maxFact = 20;
        MemoizedFactorial mf = new MemoizedFactorial(maxFact);
        for(int i = 0; i <= maxFact; i++)
            //noinspection AssertWithSideEffects
            assert mf.factorial(i) == Combinatorics.factorial(i);
    }


    @Test
    void compareTimes() {
        measureTime(this::fact0);
        measureTime(this::fact1);
        measureTime(this::fact2);
    }



    void fact0(int limit) {
        for(int i = 0; i <= limit; i++) {
            Combinatorics.factorial(i);
        }
    }

    void fact1(int limit) {
        MemoizedFactorial mf1 = new MemoizedFactorial(limit);
        for(int i = 0; i <= limit; i++) {
            mf1.factorial(i);
        }
    }

    // Using MemoizedFactorial but iterating backwards
    void fact2(int limit) {
        MemoizedFactorial mf2 = new MemoizedFactorial(limit);
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