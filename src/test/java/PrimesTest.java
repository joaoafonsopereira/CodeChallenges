import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {

    @org.junit.jupiter.api.Test
    void isMultiple() {
        assert (Primes.isMultiple(69, 3));
    }

    @org.junit.jupiter.api.Test
    void isPrime() {
        assert Primes.isPrime(1609);
        assert Primes.isPrime(4799);
        assert Primes.isPrime(6637);
        assert Primes.isPrime(7829);

        assert !Primes.isPrime(7829 + 1);


        // TODO: test with all primes in the wikipedia list
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_prime_numbers")
                    .get();


        } catch (Exception e) {

        }
    }

    @org.junit.jupiter.api.Test
    void downloadPrimesList() {
        List<Integer> plist = Util.getPrimesList();
        System.out.println(plist);
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void testIsPrime() {
    }

    @org.junit.jupiter.api.Test
    void nextPrime() {
    }
}