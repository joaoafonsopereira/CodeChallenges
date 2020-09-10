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
        List<Integer> primesList = Util.getPrimesList();
        for(Integer p : primesList) {
            assert Primes.isPrime(p);
            if(p != 2)
                assertFalse(Primes.isPrime(p+1), "" + (p+1));
        }
    }

    @Test
    void testIsPrimeWithPrevPrimes() {
        List<Integer> primesList = Util.getPrimesList();
        List<Integer> prevPrimesList = new ArrayList<>();
        for(Integer p : primesList) {
            assert Primes.isPrime(p, prevPrimesList);
            if(p != 2)
                assertFalse(Primes.isPrime(p+1, prevPrimesList), "" + (p+1));
            prevPrimesList.add(p);
        }
    }

    @Test
    void testPrimesIterator() {
        List<Integer> primesList = Util.getPrimesList();
        Iterator<Integer> primesIt = Primes.newPrimesIterator();

        for(Integer p : primesList) {
            int p2 = primesIt.next();
            assert p == p2;
        }
    }





}