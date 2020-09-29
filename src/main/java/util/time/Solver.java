package util.time;

/**
 * Interface used to pass the main method that solves a problem
 * as an argument to a method that measures its execution time.
 */
@FunctionalInterface
public interface Solver {

    void solve();

}
