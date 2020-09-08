import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {

    @org.junit.jupiter.api.Test
    void isMultiple() {
        assert(Primes.isMultiple(69, 3));
    }

    @org.junit.jupiter.api.Test
    void isPrime() {
        assert Primes.isPrime(1609);
        assert Primes.isPrime(4799);
        assert Primes.isPrime(6637);
        assert Primes.isPrime(7829);

        assert !Primes.isPrime(7829+1);
    }

    @org.junit.jupiter.api.Test
    void testIsPrime() {
    }

    @org.junit.jupiter.api.Test
    void nextPrime() {
    }
}