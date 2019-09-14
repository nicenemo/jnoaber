package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 15 elements.
 */
public interface Tuple15 extends Tuple {

    @Override
    default int size() {
      return 15;
    }
}