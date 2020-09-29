package util.time;


public class Time {


    static final String TIME_IN_SECS_BASE = "Time: %f seconds.\n";

    public static long measureNanoTime(Solver method) {
        long start = System.nanoTime();
            method.solve();
        return System.nanoTime() - start;
    }

    public static void printTimeAsSeconds(long timeInNanos) {
        double timeInSecs = timeInNanos * 1.0 / 1000000000;
        System.out.printf(TIME_IN_SECS_BASE, timeInSecs);
    }

    public static void measureAndPrintExecTime(Solver solver) {
        long execTime = measureNanoTime(solver);
        printTimeAsSeconds(execTime);
    }

}
