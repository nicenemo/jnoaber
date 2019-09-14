package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 4 elements.
 */
public interface Tuple4 extends Tuple {

    @Override
    default int size() {
      return 4;
    }
}