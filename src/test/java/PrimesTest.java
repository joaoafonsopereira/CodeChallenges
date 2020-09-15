import org.junit.jupiter.api.Test;
import primes.Primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {

    @Test
    void testIsMultiple() {
        assert (Primes.isMultiple(69, 3));
    }

    @Test
    void testIsPrimeNoPrevPrimes() {
        List<Long> primesList = Util.getPrimesList();
        for (Long p : primesList) {
            assert Primes.isPrime(p);
            if (p != 2)
                assertFalse(Primes.isPrime(p + 1), "" + (p + 1));
        }
    }

    @Test
    void testIsPrimeWithPrevPrimes() {
        List<Long> primesList = Util.getPrimesList();
        List<Long> prevPrimesList = new ArrayList<>();
        for (Long p : primesList) {
            assert Primes.isPrime(p, prevPrimesList);
            if (p != 2)
                assertFalse(Primes.isPrime(p + 1, prevPrimesList), "" + (p + 1));
            prevPrimesList.add(p);
        }
    }

    @Test
    void testPrimesIterator() {
        List<Long> primesList = Util.getPrimesList();
        Iterator<Long> primesIt = Primes.newPrimesIterator();

        for (Long p : primesList) {
            long p2 = primesIt.next();
            assert p == p2;
        }
    }


}