package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 9 elements.
 */
public interface Tuple9 extends Tuple {

    @Override
    default int size() {
      return 9;
    }
}