package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 8 elements.
 */
public interface Tuple8 extends Tuple {

    @Override
    default int size() {
      return 8;
    }
}