import java.util.List;

public class Primes {

    static boolean isMultiple(int x, int y) {
        return (x % y) == 0;
    }

    /**
     * https://en.wikipedia.org/wiki/Primality_test#Pseudocode
     */
    private static boolean isPrime(int n, int init6kMinus1) {
        if (init6kMinus1 <= 5) { // if init6kMinus1 > 5, these tests were already done
            if (n <= 3)
                return n > 1;
            if (isMultiple(n, 2) || isMultiple(n, 3))
                return false;
        }
        int i = init6kMinus1;
        while (i * i <= n) {
            if (isMultiple(n, i) || isMultiple(n, i + 2)) // 6k-1 || 6k+1
                return false;
            i += 6;
        }
        return true;
    }

    static boolean isPrime(int n) {
        return isPrime(n, 5);
    }

    static boolean isPrime(int n, List<Integer> prevPrimes) {
        for (Integer p : prevPrimes) {
            if (isMultiple(n, p))
                return false;
        }
        int last = prevPrimes.get(prevPrimes.size() - 1);
        return isPrime(n, closest6kMinus1(last));
    }

    // returns m such that m = 6k-1 (for some k) && m <= n
    private static int closest6kMinus1(int n) {
        if (n <= 5)
            return 5;
        while (!isMultiple(n + 1, 6)) {
            n--;
        }
        return n;
    }

    static int nextPrime(List<Integer> prevPrimes) {
        int curr = prevPrimes.get(prevPrimes.size() - 1);
        while (true) {
            curr++;
            if (isPrime(curr, prevPrimes))
                return curr;
        }
    }

}
