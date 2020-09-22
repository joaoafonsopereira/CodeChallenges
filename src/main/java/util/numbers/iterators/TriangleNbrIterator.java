package util.numbers.iterators;

import java.util.Iterator;


public class TriangleNbrIterator implements Iterator<Long> {

    long currTriangle;
    long currNatNbr;

    public TriangleNbrIterator() {
        currTriangle = 0;
        currNatNbr = 1;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        currTriangle += currNatNbr;
        currNatNbr++;
        return currTriangle;
    }

    @Override
    public void remove() {/*empty*/}
}
