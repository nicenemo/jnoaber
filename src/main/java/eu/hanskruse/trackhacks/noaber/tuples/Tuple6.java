package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 6 elements.
 */
public interface Tuple6 extends Tuple {

    @Override
    default int size() {
      return 6;
    }
}