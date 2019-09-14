package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 10 elements.
 */
public interface Tuple10 extends Tuple {

    @Override
    default int size() {
      return 10;
    }
}