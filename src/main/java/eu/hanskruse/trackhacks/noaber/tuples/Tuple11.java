package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 11 elements.
 */
public interface Tuple11 extends Tuple {

    @Override
    default int size() {
      return 11;
    }
}