package exceptions;

public class OutOfRangeException extends RuntimeException {

    static final String FORMAT = "%s out of range: [%d, %d]";

    public OutOfRangeException(String var, int lower, int upper) {
        super(String.format(FORMAT, var, lower, upper));
    }

}
