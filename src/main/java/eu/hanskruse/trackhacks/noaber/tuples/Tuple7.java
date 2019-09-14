package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 7 elements.
 */
public interface Tuple7 extends Tuple {

    @Override
    default int size() {
      return 7;
    }
}