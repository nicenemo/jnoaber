package eu.hanskruse.trackhacks.noaber.tuples;

/**
 * Tuple of 16 elements.
 */
public interface Tuple16 extends Tuple {

    @Override
    default int size() {
      return 16;
    }
}