package probs1to10;

import java.util.List;

import static util.numbers.Primes.sieveOfEratosthenes;

public class Prob10 {

    static final int LIMIT = 2000000;

    public static void main(String[] args) {
        long start = System.nanoTime();
        List<Integer> primesUpToLimit = sieveOfEratosthenes(LIMIT);
        long sum = 0;
        for (Integer i : primesUpToLimit)
            sum += i;
        long time = System.nanoTime() - start;
        double dur = 1.0*time/1000000000;
        System.out.println("Time: " + dur + "s");
        System.out.println(sum);
    }
}
