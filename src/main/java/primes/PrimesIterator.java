package primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static primes.Primes.isPrime;

/**
 * Prime numbers generator. Saves all the previous primes in order to speed up
 * the primality tests. Might not be the most efficient way in other problems.
 */
public class PrimesIterator implements Iterator<Long> {

    long current;
    final List<Long> prevPrimes;

    public PrimesIterator() {
        this.current = 1;
        this.prevPrimes = new ArrayList<>();
    }

/*    PrimesIterator(int prevPrime) {
        this.current = prevPrime;
        this.prevPrimes = new ArrayList<>();
    }

    PrimesIterator(List<Long> prevPrimes) {
        this.current = prevPrimes.get(prevPrimes.size()-1);
        this.prevPrimes = new ArrayList<>(prevPrimes);
    }
*/

    @Override
    public boolean hasNext() {
        return true; // infinitely many primes
    }

    @Override
    public Long next() {
        final int incr = current <= 2 ? 1 : 2;
        current += incr;
        while (!isPrime(current, prevPrimes))
            current += incr;

        prevPrimes.add(current);
        return current;
    }

    @Override
    public void remove() {
    }

}
