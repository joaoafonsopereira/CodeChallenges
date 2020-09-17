
import java.util.List;

import static primes.Primes.sieveOfEratosthenes;

public class Prob10 {

    static final int LIMIT = 2000000;

    public static void main(String[] args) {
        List<Integer> primesUpToLimit = sieveOfEratosthenes(LIMIT);
        long sum = 0;
        for (Integer i : primesUpToLimit)
            sum += i;
        System.out.println(sum);
    }
}
