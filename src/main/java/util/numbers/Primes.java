package util.numbers;

import util.numbers.iterators.PrimesIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static util.numbers.Generic.isMultiple;

public class Primes {

    public static boolean isPrime(long n) {
        return isPrime(n, 5);
    }

    public static boolean isPrime(long n, List<Long> prevPrimes) {
        for (Long p : prevPrimes) {
            if (isMultiple(n, p))
                return false;
        }
        long last = prevPrimes.size() > 0 ? prevPrimes.get(prevPrimes.size() - 1) : 1;
        return isPrime(n, closest6kMinus1(last));
    }

    public static Iterator<Long> newPrimesIterator() {
        return new PrimesIterator();
    }

    public static long getNthPrime(long n) {
        Iterator<Long> pIt = newPrimesIterator();
        for (int i = 0; i < (n - 1); i++) // stop at (n-1)th
            pIt.next();
        return pIt.next();
    }

    /**
     * Generate all the primes up to {@code limit}.
     * Adapted from https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_and_variants
     */
    public static List<Integer> sieveOfEratosthenes(int limit) {
        final int sqrt = (int) Math.sqrt(limit);
        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> res = new ArrayList<>(limit);

        for (int i = 2; i <= limit; i++)
            isPrime[i] = true;

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                if (i <= sqrt) { // this check is here because I merged the last 2 loops
                    for (int j = i * i; j <= limit; j += i)
                        isPrime[j] = false;
                }
                res.add(i);
            }
        }
        return res;
    }




    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////// PRIVATE METHODS
    /////////////////////////////////////////////////////////////////////////////////////////


    // https://en.wikipedia.org/wiki/Primality_test#Pseudocode
    private static boolean isPrime(long n, long init6kMinus1) {
        if (init6kMinus1 <= 5) { // if init6kMinus1 > 5, these tests were already done
            if (n <= 3)
                return n > 1;
            if (isMultiple(n, 2) || isMultiple(n, 3))
                return false;
        }
        long i = init6kMinus1;
        while (i * i <= n) {
            if (isMultiple(n, i) || isMultiple(n, i + 2)) // 6k-1 || 6k+1
                return false;
            i += 6;
        }
        return true;
    }

    // returns m such that m = 6k-1 (for some k) && m <= n
    private static long closest6kMinus1(long n) {
        if (n <= 5)
            return 5;
        while (!isMultiple(n + 1, 6)) {
            n--;
        }
        return n;
    }

}
