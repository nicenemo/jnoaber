package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 3 elements.
 */
public interface Tuple3 extends Tuple {

    @Override
    default int size() {
      return 3;
    }
}