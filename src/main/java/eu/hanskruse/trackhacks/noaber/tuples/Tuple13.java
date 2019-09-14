package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 13 elements.
 */
public interface Tuple13 extends Tuple {

    @Override
    default int size() {
      return 13;
    }
}