package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 12 elements.
 */
public interface Tuple12 extends Tuple {

    @Override
    default int size() {
      return 12;
    }
}