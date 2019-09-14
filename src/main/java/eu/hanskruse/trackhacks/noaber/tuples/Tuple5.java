package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 5 elements.
 */
public interface Tuple5 extends Tuple {

    @Override
    default int size() {
      return 5;
    }
}